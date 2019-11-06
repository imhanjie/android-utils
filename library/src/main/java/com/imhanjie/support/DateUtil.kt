@file:JvmName("DateUtil")

package com.imhanjie.support

import android.text.TextUtils
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * 日期时间工具类
 *
 * @date    2019-09-24
 * @author  hanjie
 */

const val UTC = "yyyy-MM-dd'T'HH:mm:ssZ" // 2017-04-23T14:36:53+0800
const val UTC_1 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ" // 2017-07-27T11:26:19.805+08:00
const val MMddyyyyHHmmss = "MM-dd-yyyy HH:mm:ss" // 05-10-2017 15:33:00
const val EEEE = "EEEE" // 星期四
const val HHmm = "HH:mm" // 14:20
const val yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss" // 2017-05-10 15:33:00
const val yyyyMMddHHmmss1 = "yyyy.MM.dd HH:mm:ss" // 2017.05.10 15:33:00
const val yyyyMMdd1 = "yyyy-MM-dd" // 2017-05-10
const val yyyyMMddHHmm = "yyyy-MM-dd HH:mm" // 2017-05-10 15:33
const val yyyyMMddHHmm1 = "yyyy/MM/dd HH:mm" // 2017/05/10 15:33
const val yyyyMMdd2 = "yyyy/MM/dd" // 2017/07/28
const val MMddHHmm = "MM-dd HH:mm" // 05-10 15:33
const val MMdd = "MM-dd" // 05-10
const val MMddHHmmss = "MM-dd HH:mm:ss" // 05-10 15:33:00
const val yyyyMMddZ = "yyyy-MM-ddZ" // 2017-07-15+08:00
const val yyyyMM = "yyyy-MM" // 2017-07

/**
 * 生成时间格式
 */
fun getFormat(pattern: String): SimpleDateFormat {
    return SimpleDateFormat(pattern, Locale.getDefault())
}

@JvmOverloads
fun formatDate(date: Date?, format: SimpleDateFormat, defaultResult: String = "暂无"): String {
    return date?.let { format.format(date) } ?: defaultResult
}

fun formatDate(
    sourceStr: String?,
    sourceFormat: SimpleDateFormat,
    targetFormat: SimpleDateFormat,
    defaultResult: String? = "暂无"
): String? {
    if (TextUtils.isEmpty(sourceStr)) {
        return defaultResult
    }
    return try {
        val date = sourceFormat.parse(sourceStr)
        targetFormat.format(date)
    } catch (e: Exception) {
        defaultResult
    }
}

fun formatToDate(sourceStr: String?, sourceFormat: SimpleDateFormat): Date {
    if (TextUtils.isEmpty(sourceStr)) {
        return Date()
    }
    return try {
        sourceFormat.parse(sourceStr)
    } catch (e: Exception) {
        Date()
    }
}

fun formatDateUTC(sourceStr: String?, targetFormat: SimpleDateFormat): String? {
    return formatDate(sourceStr, getFormat(UTC), targetFormat)
}

fun formatUTCTimeToDate(ut: String): Date {
    var utcTime = ut
    if (TextUtils.isEmpty(utcTime)) {
        return Date()
    }
    try {
        val timeZone: String
        if (!utcTime.endsWith("Z")) {
            //末尾不包含Z,则不需要减去8小时
            utcTime += "Z"
            timeZone = "+0800"
        } else {
            timeZone = "+0000"
        }
        return getFormat(UTC).parse(utcTime.replace("Z$".toRegex(), timeZone))
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return Date()
}

fun isSameDay(d1: Date, d2: Date): Boolean {
    var isSameDay = false
    val c1 = Calendar.getInstance()
    c1.time = d1
    val c2 = Calendar.getInstance()
    c2.time = d2
    if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) && c1.get(Calendar.DAY_OF_YEAR) - c2.get(
            Calendar.DAY_OF_YEAR
        ) == 0
    ) {
        isSameDay = true
    }
    return isSameDay
}

/**
 * 格式化分钟
 */
fun formatStatusTime(millis: Long): String {
    val s = millis / 1000
    val days = s / 86400
    val hours = s % 86400 / 3600
    val minutes = s / 60 % 60
    val seconds = s % 60
    if (days != 0L) {
        return days.toString() + "天" + if (hours != 0L) hours.toString() + "时" else ""
    }
    if (hours != 0L) {
        return hours.toString() + "时" + if (minutes != 0L) minutes.toString() + "分" else ""
    }
    return if (minutes != 0L) {
        minutes.toString() + "分" + if (seconds != 0L) seconds.toString() + "秒" else ""
    } else seconds.toString() + "秒"
}

/**
 * 生成一个当天时间为 00:00 的 Calendar 对象（秒和毫秒均为0）
 */
fun getPureCalendar(): Calendar {
    val c = Calendar.getInstance()
    c.set(Calendar.HOUR_OF_DAY, 0)
    c.set(Calendar.MINUTE, 0)
    c.set(Calendar.SECOND, 0)
    c.set(Calendar.MILLISECOND, 0)
    return c
}