package com.vr.mecali.common

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.text.DecimalFormat

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    Glide.with(view).load(url).into(view)
}

@BindingAdapter("priceItem", "currencyId")
fun formatPrice(view: TextView, price: Long, currency: String) {
    val formatter = DecimalFormat("$ #,###")
    val text = "${formatter.format(price)} $currency"
    view.text = text
}