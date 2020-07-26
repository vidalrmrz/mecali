package com.vr.mecali.modules.search.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vr.domain.entities.ItemEntity

class SearchAdapter(val onClick: (ItemEntity) -> Unit) :
    ListAdapter<ItemEntity, RecyclerView.ViewHolder>(ItemEntityDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolderSearch.from(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as ViewHolderSearch).bind(item, onClick)
    }

}

class ItemEntityDiffCallback : DiffUtil.ItemCallback<ItemEntity>() {
    override fun areItemsTheSame(oldItem: ItemEntity, newItem: ItemEntity): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ItemEntity, newItem: ItemEntity): Boolean =
        oldItem == newItem

}