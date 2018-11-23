package keijumt.trainingandroiddesign.ui.youtube

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import keijumt.trainingandroiddesign.R

class YoutubeActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context): Intent = Intent(context, YoutubeActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube)
    }
}
