package keijumt.trainingandroiddesign.ui.thread

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.PopupWindow
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProviders
import keijumt.trainingandroiddesign.BaseFragment
import keijumt.trainingandroiddesign.R
import keijumt.trainingandroiddesign.ui.main.MainViewModel
import kotlinx.android.synthetic.main.fragment_thread.view.*
import kotlinx.android.synthetic.main.menu_thread.view.*


class ThreadFragment : BaseFragment() {

    companion object {
        fun newInstance() = ThreadFragment()
    }

    private lateinit var threadViewModel: ThreadViewModel
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_thread, container, false)
        view.container_workspace_list.setOnClickListener {
            mainViewModel.event.value = MainViewModel.Event.Workspaces
        }
        setHasOptionsMenu(true)

        val popupWindow = PopupWindow(requireContext())
        // PopupWindowの外をタッチしたらPopupWindowが閉じるように設定
        popupWindow.isOutsideTouchable = true
        val contentView = LayoutInflater.from(requireContext()).inflate(R.layout.menu_thread, null)

        // PopupWindowに表示するViewのサイズを設定
        val width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 240f, requireContext().resources.displayMetrics)
        popupWindow.width = width.toInt()
        popupWindow.height = WindowManager.LayoutParams.WRAP_CONTENT
        popupWindow.setBackgroundDrawable(ResourcesCompat.getDrawable(resources, R.drawable.abc_popup_background_mtrl_mult, null))

        contentView.menu_home.setOnClickListener {
            popupWindow.dismiss()
        }
        contentView.menu_direct_message.setOnClickListener {
            popupWindow.dismiss()
        }
        contentView.menu_item_star.setOnClickListener {
            popupWindow.dismiss()
        }

        popupWindow.contentView = contentView

        // TODO: ポップアップを出す場所の調整の仕方を変える
        view.container_menu.setOnClickListener {
            popupWindow.showAsDropDown(it,
                    -(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8f, requireContext().resources.displayMetrics)).toInt(),
                    -it.height + (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8f, requireContext().resources.displayMetrics)).toInt())
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        threadViewModel = ViewModelProviders.of(requireActivity()).get(ThreadViewModel::class.java)
        mainViewModel = ViewModelProviders.of(requireActivity()).get(MainViewModel::class.java)
    }
}
