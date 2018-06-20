package keijumt.trainingandroiddesign.model

import java.util.*

data class Talk(
        val name: String = "",
        val text: String = "",
        val date: Date,
        val thumbnailUtl: String = "",
        val isSection: Boolean = false
)