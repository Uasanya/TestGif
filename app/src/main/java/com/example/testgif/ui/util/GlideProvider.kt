package com.example.testgif.ui.util

import android.content.Context
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.ImageViewTarget
import com.example.testgif.R

object GlideProvider {

    fun ImageView.setGif(url: String) {
        Glide.with(context)
            .asGif()
            .load(url)
            .into(this)
    }
}