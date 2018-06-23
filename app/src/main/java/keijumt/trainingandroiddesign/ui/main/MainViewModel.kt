package keijumt.trainingandroiddesign.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    enum class Event {
        Thread,
        Workspaces
    }

    val event = MutableLiveData<Event>()
}