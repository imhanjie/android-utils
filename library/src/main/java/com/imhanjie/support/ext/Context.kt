package com.imhanjie.support.ext

import android.content.Context
import android.widget.Toast

/**
 * @date    2019-11-07
 * @author  hanjie
 */

fun Context.toast(msg: CharSequence, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, msg, duration).show()

fun Context.toast(resId: Int, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, resId, duration).show()