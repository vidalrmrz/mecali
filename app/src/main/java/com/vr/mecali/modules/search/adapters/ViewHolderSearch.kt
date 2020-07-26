package com.vr.mecali.modules.search.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vr.domain.entities.ItemEntity
import com.vr.mecali.databinding.ItemSearchBinding

class ViewHolderSearch private constructor(val binding: ItemSearchBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup): ViewHolderSearch {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemSearchBinding.inflate(layoutInflater, parent, false)
            return ViewHolderSearch(binding)
        }
    }

    fun bind(item: ItemEntity, onClick: (ItemEntity) -> Unit) {
        binding.itemContainer.setOnClickListener {
            onClick.invoke(item)
        }
        binding.itemSearch = item
        binding.executePendingBindings()
    }
}