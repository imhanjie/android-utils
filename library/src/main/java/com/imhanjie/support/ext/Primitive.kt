package com.imhanjie.support.ext

import android.util.TypedValue
import androidx.core.content.ContextCompat
import com.imhanjie.support.AndroidUtils

val Float.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        AndroidUtils.APP.resources.displayMetrics
    )

val Float.sp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        this,
        AndroidUtils.APP.resources.displayMetrics
    )

val Int.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        AndroidUtils.APP.resources.displayMetrics
    )

val Int.sp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        this.toFloat(),
        AndroidUtils.APP.resources.displayMetrics
    )

val Int.string
    get() = AndroidUtils.APP.getString(this)

val Int.drawable
    get() = ContextCompat.getDrawable(AndroidUtils.APP, this)

val Int.color
    get() = ContextCompat.getColor(AndroidUtils.APP, this)