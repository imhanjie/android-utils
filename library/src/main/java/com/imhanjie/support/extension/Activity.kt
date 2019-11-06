package com.imhanjie.support.extension

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat

/**
 * Activity 扩展
 *
 * @date    2019-10-24
 * @author  hanjie
 */

inline fun <reified T> Activity.toActivity(
        extraMap: Map<String, Any>? = null, requestCode: Int = -1) {
    val intent = Intent(this, T::class.java)
    extraMap?.let { intent.putExtrasMap(it) }
    startActivityForResult(intent, requestCode)
}

fun Activity.toast(msg: CharSequence, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, msg, duration).show()

fun Activity.toast(resId: Int, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, resId, duration).show()

fun Activity.getResColor(colorResId: Int): Int {
    return ContextCompat.getColor(this, colorResId)
}