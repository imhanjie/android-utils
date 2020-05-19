package com.imhanjie.support.ext

import android.util.TypedValue
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
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

val @receiver:StringRes Int.string
    get() = AndroidUtils.APP.getString(this)

fun @receiver:StringRes Int.string(vararg formatArgs: Any?) =
    AndroidUtils.APP.getString(this, *formatArgs)

val @receiver:DrawableRes Int.drawable
    get() = ContextCompat.getDrawable(AndroidUtils.APP, this)

val @receiver:ColorRes Int.color
    get() = ContextCompat.getColor(AndroidUtils.APP, this)