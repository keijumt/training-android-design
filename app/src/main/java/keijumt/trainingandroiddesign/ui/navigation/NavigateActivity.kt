package keijumt.trainingandroiddesign.ui.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import keijumt.trainingandroiddesign.R
import keijumt.trainingandroiddesign.ui.slack.main.SlackActivity
import keijumt.trainingandroiddesign.ui.youtube.YoutubeActivity
import kotlinx.android.synthetic.main.activity_navigate.*

class NavigateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigate)

        btn_start_slack.setOnClickListener {
            startActivity(SlackActivity.createIntent(this))
        }

        btn_start_youtube.setOnClickListener {
            startActivity(YoutubeActivity.createIntent(this))
        }

    }
}
