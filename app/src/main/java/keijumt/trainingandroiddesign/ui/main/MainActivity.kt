package keijumt.trainingandroiddesign.ui.main

import android.os.Bundle
import keijumt.trainingandroiddesign.BaseActivity
import keijumt.trainingandroiddesign.R
import keijumt.trainingandroiddesign.ui.talk.TalkFragment
import keijumt.trainingandroiddesign.ui.thread.ThreadFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Main
        addFragment(TalkFragment.newInstance(), R.id.container_main)

        // Navigation
        addFragment(ThreadFragment.newInstance(), R.id.container_drawer)

        // Iconクリック時にNavigationDrawerを開く
        icon_main.setOnClickListener {
            drawer_layout.openDrawer(navigation_drawer)
        }
    }
}
