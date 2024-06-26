package com.example.gourmetberlin.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.example.gourmetberlin.R

class Footer @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.footer, this)
    }
}
