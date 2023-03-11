package com.ags.lcz.customview

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-11
 */
class CustomSwipeRefreshLayout(context: Context, attrs: AttributeSet) :
    SwipeRefreshLayout(context, attrs) {

    // 不拦截任何 子 view  事件
    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }
}