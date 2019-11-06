@file:JvmName("DimensionUtil")

package com.imhanjie.support

import android.util.TypedValue

fun dp(dpValue: Float): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dpValue,
        AndroidUtils.INSTANCE.resources.displayMetrics
    )
}

fun sp(spValue: Float): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        spValue,
        AndroidUtils.INSTANCE.resources.displayMetrics
    )
}