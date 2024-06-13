package com.example.gourmetberlin.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import com.example.gourmetberlin.R
import com.squareup.picasso.Picasso

class Banner @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.banner, this)
        val bannerImage: ImageView = findViewById(R.id.banner_image)
        val imageUrl = "https://i.ibb.co/YBpQRrj/Capture.png"

        Picasso.get()
            .load(imageUrl)
            .into(bannerImage)
    }
}
