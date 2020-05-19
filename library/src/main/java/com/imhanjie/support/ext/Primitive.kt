package com.imhanjie.support.ext

import android.util.TypedValue
import com.imhanjie.support.AndroidUtils

val Float.dp: Float
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        AndroidUtils.APP.resources.displayMetrics
    )

val Float.dpi: Int
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        AndroidUtils.APP.resources.displayMetrics
    ).toInt()

val Float.sp: Float
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        this,
        AndroidUtils.APP.resources.displayMetrics
    )

val Float.spi: Int
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        this,
        AndroidUtils.APP.resources.displayMetrics
    ).toInt()

val Int.dp: Float
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        AndroidUtils.APP.resources.displayMetrics
    )

val Int.dpi: Int
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        AndroidUtils.APP.resources.displayMetrics
    ).toInt()

val Int.sp: Float
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        this.toFloat(),
        AndroidUtils.APP.resources.displayMetrics
    )

val Int.spi: Int
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        this.toFloat(),
        AndroidUtils.APP.resources.displayMetrics
    ).toInt()