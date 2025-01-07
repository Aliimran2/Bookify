package com.mias.bookify.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade

fun ImageView.loadOnline(imageUrl: String){
    Glide.with(this.context)
        .load(imageUrl)
        .transition(withCrossFade())
        .thumbnail(Glide.with(context).load(imageUrl).override(100,100))
        .into(this)
}