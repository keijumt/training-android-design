package keijumt.trainingandroiddesign.ui.slack.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlackViewModel : ViewModel() {
    enum class Event {
        Thread,
        Workspaces
    }

    val event = MutableLiveData<Event>()
}