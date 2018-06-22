package keijumt.trainingandroiddesign.ui.talk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import keijumt.trainingandroiddesign.BaseFragment
import keijumt.trainingandroiddesign.R
import keijumt.trainingandroiddesign.model.Talk
import keijumt.trainingandroiddesign.util.TimeUtil
import kotlinx.android.synthetic.main.fragment_talk.view.*
import java.util.*

class TalkFragment : BaseFragment() {

    companion object {
        fun newInstance() = TalkFragment()
    }

    private lateinit var viewModel: TalkViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_talk, container, false)
        val adapter = TalkAdapter()
        val talks = createDummyData()
        view.recycler_talk.also {
            it.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
            it.adapter = adapter
        }
        adapter.appendTalk(talks.sortedBy { it.date })
        view.recycler_talk.scrollToPosition(adapter.talks.size - 1)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(TalkViewModel::class.java)
    }

    private fun createDummyData(): List<Talk> {
        val talks = arrayListOf<Talk>()
        for (i in 0 until 20) {
            talks.add(
                    Talk(
                            name = "test name",
                            text = UUID.randomUUID().toString(),
                            date = TimeUtil.getRandomDate()
                    )
            )
        }
        return talks
    }

}
