package com.imhanjie.support.ext

import android.util.TypedValue
import com.imhanjie.support.AndroidUtils

fun Float.dp() = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    this,
    AndroidUtils.APP.resources.displayMetrics
)

fun Float.sp() = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_SP,
    this,
    AndroidUtils.APP.resources.displayMetrics
)