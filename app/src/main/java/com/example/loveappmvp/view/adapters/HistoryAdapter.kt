package com.example.loveappmvp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.loveappmvp.model.HistoryModel
import com.example.lovecalculator.databinding.ItemHistoryBinding

class HistoryAdapter(
    var isGridLayout: Boolean
): ListAdapter<HistoryModel, HistoryAdapter.ViewHolder>(DIffCallback()) {
    class ViewHolder(private val binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HistoryModel) {
            binding.txtTitleNote.text = item.title
            binding.txtDescriptionNote.text = item.description
            binding.txtDate.text = item.date
            binding.txtTime.text = item.time
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        if (isGridLayout) {
            holder.itemView.layoutParams.height = 250
        } else {
            holder.itemView.layoutParams.height = 150
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    class DIffCallback: DiffUtil.ItemCallback<HistoryModel>(){
        override fun areItemsTheSame(oldItem: HistoryModel, newItem: HistoryModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: HistoryModel, newItem: HistoryModel): Boolean {
            return oldItem == newItem
        }
    }
}