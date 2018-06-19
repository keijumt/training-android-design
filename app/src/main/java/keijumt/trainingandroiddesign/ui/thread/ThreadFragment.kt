package keijumt.trainingandroiddesign.ui.thread

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import keijumt.trainingandroiddesign.BaseFragment
import keijumt.trainingandroiddesign.R

class ThreadFragment : BaseFragment() {

    companion object {
        fun newInstance() = ThreadFragment()
    }

    private lateinit var viewModel: ThreadViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_thread, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity()).get(ThreadViewModel::class.java)
    }

}
