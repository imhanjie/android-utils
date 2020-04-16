package com.imhanjie.support.ext

import android.app.Activity
import androidx.core.content.ContextCompat

/**
 * @date    2019-10-24
 * @author  hanjie
 */

fun Activity.getResColor(colorResId: Int): Int {
    return ContextCompat.getColor(this, colorResId)
}

fun Activity.post(action: () -> Unit) = window.decorView.post(action)

fun Activity.postDelayed(delayMillis: Long, action: () -> Unit) =
    window.decorView.postDelayed(action, delayMillis)