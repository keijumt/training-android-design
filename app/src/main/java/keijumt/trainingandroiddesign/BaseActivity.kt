package keijumt.trainingandroiddesign

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

open class BaseActivity : AppCompatActivity() {

    protected fun addFragment(fragment: Fragment, containerViewId: Int) {
        supportFragmentManager.findFragmentById(containerViewId)?.let {
            return
        }
        supportFragmentManager
                .beginTransaction()
                .add(containerViewId, fragment)
                .commit()
    }

}