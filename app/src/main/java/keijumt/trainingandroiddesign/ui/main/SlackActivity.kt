package keijumt.trainingandroiddesign.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import keijumt.trainingandroiddesign.BaseActivity
import keijumt.trainingandroiddesign.R
import keijumt.trainingandroiddesign.ui.talk.TalkFragment
import keijumt.trainingandroiddesign.ui.thread.ThreadFragment
import keijumt.trainingandroiddesign.ui.workspaces.WorkspaceFragment
import kotlinx.android.synthetic.main.activity_slack.*
import kotlinx.android.synthetic.main.app_bar_main.*

class SlackActivity : BaseActivity() {

    companion object {
        fun createIntent(context: Context): Intent = Intent(context, SlackActivity::class.java)
    }

    private val slackViewModel: SlackViewModel by lazy {
        ViewModelProviders.of(this).get(SlackViewModel::class.java)
    }

    private var threadFragment: ThreadFragment? = null
    private var workspaceFragment: WorkspaceFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slack)

        // Main
        addFragment(TalkFragment.newInstance(), R.id.container_main)

        // Navigation
        addFragment(threadFragment
                ?: ThreadFragment.newInstance().also { threadFragment = it }, R.id.container_drawer)

        // Iconクリック時にNavigationDrawerを開く
        icon_main.setOnClickListener {
            drawer_layout.openDrawer(navigation_drawer)
        }

        drawer_layout.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerStateChanged(newState: Int) {
            }

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
            }

            override fun onDrawerClosed(drawerView: View) {
                if (currentFragment(R.id.container_drawer) is WorkspaceFragment) {
                    replaceFragment(threadFragment
                            ?: ThreadFragment.newInstance().also { threadFragment = it }, R.id.container_drawer)
                }
            }

            override fun onDrawerOpened(drawerView: View) {
            }
        })

        subscribe()
    }

    private fun subscribe() {
        slackViewModel.event.observe(this, Observer {
            when (it) {
                SlackViewModel.Event.Thread -> {
                    replaceFragment(threadFragment
                            ?: ThreadFragment.newInstance().also { threadFragment = it }, R.id.container_drawer)
                }
                SlackViewModel.Event.Workspaces -> {
                    replaceFragment(workspaceFragment
                            ?: WorkspaceFragment.newInstance().also { workspaceFragment = it }, R.id.container_drawer)
                }
            }
        })
    }
}
