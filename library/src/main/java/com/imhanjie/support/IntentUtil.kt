@file:JvmName("IntentUtil")

package com.imhanjie.support

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings

/**
 * Description
 *
 * @date    2019-09-26
 * @author  hanjie
 */

/**
 * 跳转到应用自身系统设置页面
 */
fun intentToSelfSettings(context: Context): Boolean {
    return try {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        intent.apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            data = Uri.fromParts("package", context.packageName, null)
        }
        context.startActivity(intent)
        true
    } catch (ignore: Exception) {
        false
    }
}

/**
 * 跳转到系统 Gps 开关设置
 */
fun intentToGpsSettings(context: Context): Boolean {
    return try {
        val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
        true
    } catch (ignore: Exception) {
        false
    }
}

/**
 * url跳转（使用手机浏览器）
 */
fun intentToBrowser(context: Context, url: String) {
    try {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        context.startActivity(intent)
    } catch (ignore: Exception) {
    }

}