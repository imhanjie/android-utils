package com.imhanjie.support.ext

import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

/**
 * @date    2019-10-22
 * @author  hanjie
 */

fun Fragment.toast(msg: CharSequence, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(context, msg, duration).show()

fun Fragment.toast(resId: Int, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(context, resId, duration).show()

fun Fragment.getResColor(colorResId: Int): Int {
    return context?.let { ContextCompat.getColor(it, colorResId) } ?: 0
}

fun Fragment.post(action: () -> Unit) = view?.post(action)

fun Fragment.postDelayed(delayMillis: Long, action: () -> Unit) =
    view?.postDelayed(action, delayMillis)