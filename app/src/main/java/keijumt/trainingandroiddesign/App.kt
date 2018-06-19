package keijumt.trainingandroiddesign

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.os.Bundle
import timber.log.Timber

class App : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var instance: App
    }

    var currentActivity: Activity? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        setupLifecycle()
        setupLog()

    }

    /**
     * lifecycle
     */
    private fun setupLifecycle() {
        registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity?) {
            }

            override fun onActivityResumed(activity: Activity?) {
            }

            override fun onActivityStarted(activity: Activity?) {
                currentActivity = activity
            }

            override fun onActivityDestroyed(activity: Activity?) {
            }

            override fun onActivitySaveInstanceState(activity: Activity?, bundle: Bundle?) {
            }

            override fun onActivityStopped(activity: Activity?) {
                if (currentActivity === activity) {
                    currentActivity = null
                }
            }

            override fun onActivityCreated(activity: Activity?, bundle: Bundle?) {
            }

        })
    }

    /**
     * ログ
     */
    private fun setupLog() {
        Timber.plant(Timber.DebugTree())
    }
}