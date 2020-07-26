package com.vr.mecali.modules.search.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vr.domain.entities.PictureEntity

class ViewPagerAdapter(private val pictures: List<PictureEntity>?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolderPictures.from(parent)

    override fun getItemCount(): Int = pictures?.size ?: 0

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolderPictures).bind(pictures!![position])
    }

}