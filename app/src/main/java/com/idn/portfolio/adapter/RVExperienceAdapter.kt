package com.idn.portfolio.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idn.portfolio.R
import com.idn.portfolio.data.Portfolio
import com.idn.portfolio.databinding.ItemExperienceBinding

class RVExperienceAdapter: RecyclerView.Adapter<RVExperienceAdapter.ExperienceViewHolder>() {

    private val listData = ArrayList<Portfolio>()
    var onItemClicked: ((Portfolio) -> Unit)? = null

    fun setData(newList: List<Portfolio>?) {
        if (newList == null) return
        listData.clear()
        listData.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceViewHolder =
        ExperienceViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_experience, parent, false)
        )

    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
        val listData = listData[position]
        holder.bind(listData)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    inner class ExperienceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemExperienceBinding.bind(itemView)

        fun bind(data: Portfolio) {
            binding.experience = data
            binding.executePendingBindings()
        }

        init {
            binding.root.setOnClickListener {
                onItemClicked?.invoke(listData[adapterPosition])
            }
        }
    }
}
