package keijumt.trainingandroiddesign.ui.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import keijumt.trainingandroiddesign.R
import keijumt.trainingandroiddesign.ui.main.SlackActivity
import kotlinx.android.synthetic.main.activity_navigate.*

class NavigateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigate)

        btn_start_slack.setOnClickListener {
            startActivity(SlackActivity.createIntent(this))
        }

    }
}
