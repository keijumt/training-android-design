package keijumt.trainingandroiddesign.ui.youtube


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import keijumt.trainingandroiddesign.R
import keijumt.trainingandroiddesign.ui.youtube.player.PlayerFragment

class YoutubeFragment : Fragment() {

    companion object {
        fun newInstance(): YoutubeFragment = YoutubeFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_youtube, container, false)

        childFragmentManager.beginTransaction()
                .replace(R.id.container, PlayerFragment.newInstance())
                .commitNow()

        return view
    }
}
