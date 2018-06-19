package keijumt.trainingandroiddesign.ui.main

import android.os.Bundle
import keijumt.trainingandroiddesign.BaseActivity
import keijumt.trainingandroiddesign.R
import keijumt.trainingandroiddesign.ui.talk.TalkFragment
import keijumt.trainingandroiddesign.ui.thread.ThreadFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Main
        addFragment(TalkFragment.newInstance(), R.id.container_main)

        // Navigation
        addFragment(ThreadFragment.newInstance(), R.id.container_drawer)
    }
}
