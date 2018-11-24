package keijumt.trainingandroiddesign.ui.youtube.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import keijumt.trainingandroiddesign.R

class SpecifyViewTouchableMotionLayout @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : MotionLayout(context, attrs, defStyleAttr) {

    // タッチを受け付ける特定のView
    private val touchView by lazy {
        findViewById<View>(R.id.view_video)
    }

    private var isTouched: Boolean = false
    private val rect = Rect()

    init {
        setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                isTouched = false
            }
        })
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                isTouched = false
                return super.onTouchEvent(event)
            }
        }

        if (!isTouched) {
            touchView.getHitRect(rect)
            // 現在タッチされている範囲がtouchViewに含まれているかどうか
            isTouched = rect.contains(event.x.toInt(), event.y.toInt())
        }

        return isTouched && super.onTouchEvent(event)
    }
}