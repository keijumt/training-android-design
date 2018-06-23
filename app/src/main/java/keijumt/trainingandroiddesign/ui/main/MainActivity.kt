package keijumt.trainingandroiddesign.ui.main

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
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    private var threadFragment: ThreadFragment? = null
    private var workspaceFragment: WorkspaceFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        viewModel.event.observe(this, Observer {
            when (it) {
                MainViewModel.Event.Thread -> {
                    replaceFragment(threadFragment
                            ?: ThreadFragment.newInstance().also { threadFragment = it }, R.id.container_drawer)
                }
                MainViewModel.Event.Workspaces -> {
                    replaceFragment(workspaceFragment
                            ?: WorkspaceFragment.newInstance().also { workspaceFragment = it }, R.id.container_drawer)
                }
            }
        })
    }
}
