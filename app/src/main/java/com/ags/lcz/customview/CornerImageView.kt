package com.ags.lcz.customview

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.zhpan.bannerview.provider.ViewStyleSetter

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-11
 */
class CornerImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    fun setRoundCorner(radius: Int) {
        ViewStyleSetter.applyRoundCorner(this, radius.toFloat())
    }
}