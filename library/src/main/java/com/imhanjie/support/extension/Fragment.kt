package com.imhanjie.support.extension

import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

/**
 * Fragment 扩展
 *
 * @date    2019-10-22
 * @author  hanjie
 */

inline fun <reified T> Fragment.toActivity(
    extraMap: Map<String, Any>? = null, requestCode: Int = -1
) {
    val intent = Intent(context, T::class.java)
    extraMap?.let { intent.putExtrasMap(it) }
    startActivityForResult(intent, requestCode)
}

fun Fragment.toast(msg: CharSequence, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(context, msg, duration).show()

fun Fragment.toast(resId: Int, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(context, resId, duration).show()

fun Fragment.getResColor(colorResId: Int): Int {
    return context?.let { ContextCompat.getColor(it, colorResId) } ?: 0
}