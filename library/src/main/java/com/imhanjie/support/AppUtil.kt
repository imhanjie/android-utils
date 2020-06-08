package com.imhanjie.support

import android.content.Context
import android.os.Build

fun getAppVersionName(ctx: Context): String {
    var result = ""
    try {
        val packageInfo = ctx.packageManager.getPackageInfo(ctx.packageName, 0)
        result = packageInfo.versionName
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return result
}

fun getAppVersionCode(ctx: Context): Long {
    var result = 0L
    try {
        val packageInfo = ctx.packageManager.getPackageInfo(ctx.packageName, 0)
        result = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            packageInfo.longVersionCode
        } else {
            packageInfo.versionCode.toLong()
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return result
}