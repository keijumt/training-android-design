package keijumt.trainingandroiddesign.ui.talk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import keijumt.trainingandroiddesign.BaseFragment
import keijumt.trainingandroiddesign.R

class TalkFragment : BaseFragment() {

    companion object {
        fun newInstance() = TalkFragment()
    }

    private lateinit var viewModel: TalkViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_talk, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TalkViewModel::class.java)
    }

}
