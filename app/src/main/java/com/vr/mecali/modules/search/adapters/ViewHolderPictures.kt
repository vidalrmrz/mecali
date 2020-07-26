package com.vr.mecali.modules.search.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vr.domain.entities.PictureEntity
import com.vr.mecali.databinding.ItemPicturesBinding

class ViewHolderPictures private constructor(val binding: ItemPicturesBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup): ViewHolderPictures {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemPicturesBinding.inflate(layoutInflater, parent, false)
            return ViewHolderPictures(binding)
        }
    }

    fun bind(picture: PictureEntity?) {
        binding.picture = picture
        binding.executePendingBindings()
    }
}