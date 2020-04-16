package com.imhanjie.support.ext

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import java.io.Serializable

/**
 * @date    2019-10-22
 * @author  hanjie
 */

fun Intent.putExtrasMap(extraMap: Map<String, Any>) {
    for ((key, value) in extraMap) {
        when (value) {
            is Int -> putExtra(key, value)
            is String -> putExtra(key, value)
            is Double -> putExtra(key, value)
            is Float -> putExtra(key, value)
            is Short -> putExtra(key, value)
            is CharSequence -> putExtra(key, value)
            is Byte -> putExtra(key, value)
            is Parcelable -> putExtra(key, value)
            is Serializable -> putExtra(key, value)
            is Bundle -> putExtras(value)
        }
    }
}