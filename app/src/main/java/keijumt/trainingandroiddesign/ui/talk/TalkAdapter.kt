package keijumt.trainingandroiddesign.ui.talk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import keijumt.trainingandroiddesign.R
import keijumt.trainingandroiddesign.model.Talk
import keijumt.trainingandroiddesign.util.TimeUtil
import kotlinx.android.synthetic.main.row_talk_item.view.*
import kotlinx.android.synthetic.main.row_talk_section.view.*
import java.text.SimpleDateFormat

class TalkAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    enum class Type(value: Int) {
        Section(0),
        Item(1)
    }

    val talks = arrayListOf<Talk>()

    fun appendTalk(talks: List<Talk>) {
        val items = arrayListOf<Talk>()
        for (i in 0 until talks.size) {
            items.add(talks[i])
            // talkの間に日付の変更がある時
            if (i < talks.size - 1 && TimeUtil.dateDifference(talks[i].date, talks[i + 1].date) > 0) {
                items.add(Talk(date = TimeUtil.roundDate(talks[i + 1].date), isSection = true))
            }
        }
        this.talks.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (Type.values()[viewType]) {
            Type.Section -> {
                val inflater = LayoutInflater.from(parent.context).inflate(R.layout.row_talk_section, parent, false)
                return SectionViewHolder(inflater)
            }
            Type.Item -> {
                val inflater = LayoutInflater.from(parent.context).inflate(R.layout.row_talk_item, parent, false)
                return ItemViewHolder(inflater)
            }
            else -> {
                throw IllegalArgumentException()
            }
        }
    }

    override fun getItemCount(): Int {
        return talks.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (talks[position].isSection) Type.Section.ordinal else Type.Item.ordinal
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SectionViewHolder -> {
                holder.bind()
            }
            is ItemViewHolder -> {
                holder.bind()
            }
        }
    }

    inner class SectionViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind() {
            val sdf = SimpleDateFormat("yyyy年MM月dd")
            view.text_section_date.text = sdf.format(talks[layoutPosition].date)
        }
    }

    inner class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind() {
            view.text_user_name.text = talks[layoutPosition].name
            view.text_content.text = talks[layoutPosition].text
            val sdf = SimpleDateFormat("hh:mm")
            view.text_date.text = sdf.format(talks[layoutPosition].date)
        }
    }
}