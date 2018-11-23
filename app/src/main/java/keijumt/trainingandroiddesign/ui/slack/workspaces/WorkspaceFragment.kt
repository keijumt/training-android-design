package keijumt.trainingandroiddesign.ui.slack.workspaces

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import keijumt.trainingandroiddesign.R
import keijumt.trainingandroiddesign.ui.slack.main.SlackViewModel
import kotlinx.android.synthetic.main.fragment_workspace.view.*

class WorkspaceFragment : Fragment() {

    companion object {
        fun newInstance() = WorkspaceFragment()
    }

    private lateinit var viewModel: WorkspaceViewModel
    private lateinit var mainViewModel: SlackViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_workspace, container, false)
        view.container_close_workspaces.setOnClickListener {
            mainViewModel.event.value = SlackViewModel.Event.Thread
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WorkspaceViewModel::class.java)
        mainViewModel = ViewModelProviders.of(requireActivity()).get(SlackViewModel::class.java)
    }

}
