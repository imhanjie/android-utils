@file:JvmName("L")

package com.imhanjie.support

import android.util.Log
import com.google.gson.Gson
import org.json.JSONException
import org.json.JSONObject

/**
 * Description
 *
 * @date    2019-09-26
 * @author  hanjie
 */

private const val TAG = "bingo"
private var sTimeMillis: Long = 0
private val isDebug = AndroidUtils.isDebug

@JvmOverloads
fun e(msg: String, tag: String = TAG) {
    if (!isDebug) {
        return
    }
    Log.e(tag, "$msg\t\t${getTargetPath()}")
}

@JvmOverloads
fun w(msg: String, tag: String = TAG) {
    if (!isDebug) {
        return
    }
    Log.w(tag, "$msg\t\t${getTargetPath()}")
}

@JvmOverloads
fun i(msg: String, tag: String = TAG) {
    if (!isDebug) {
        return
    }
    Log.i(tag, "$msg\t\t${getTargetPath()}")
}

@JvmOverloads
fun d(msg: String, tag: String = TAG) {
    if (!isDebug) {
        return
    }
    Log.d(tag, "$msg\t\t${getTargetPath()}")
}

@JvmOverloads
fun v(msg: String, tag: String = TAG) {
    if (!isDebug) {
        return
    }
    Log.v(tag, "$msg\t\t${getTargetPath()}")
}

/**
 * 打印当前调用栈
 */
fun printStackTrace() {
    e(getStackTrace())
}

fun startTimer() {
    e("Timer pick.")
    sTimeMillis = System.currentTimeMillis()
}

fun stopTimer(text: String) {
    if (sTimeMillis == 0L) {
        e("Timer error.")
        return
    }
    e("Timer end. $text Spend: ${System.currentTimeMillis() - sTimeMillis} ms")
    sTimeMillis = 0
}

fun printToJson(any: Any) {
    printToJson(TAG, Gson().toJson(any))
}

@JvmOverloads
fun printToJson(json: String, tag: String = TAG) {
    if (!isDebug) {
        return
    }
    try {
        val jsonString = JSONObject(json).toString(4)
        Log.e(tag, "At: " + getTargetPath())
        val maxSize = 2000
        val length = jsonString.length
        var part = length / maxSize
        if (length % maxSize != 0) {
            part += 1
        }
        Log.e(tag, "------------------------- START -------------------------")
        for (i in 0 until part) {
            if (i == part - 1) {
                Log.e(tag, jsonString.substring(i * maxSize, length))
            } else {
                Log.e(tag, jsonString.substring(i * maxSize, (i + 1) * maxSize))
            }
        }
        Log.e(tag, "-------------------------- END --------------------------")
    } catch (e: JSONException) {
        e.printStackTrace()
        Log.e(
            tag,
            "At: " + getTargetPath() + "\n" + "Error json conversation! Please check:\n" + json
        )
    }
}

private fun getStackTrace(): String {
    val buffer = StringBuffer()
    val elements = Thread.currentThread().stackTrace
    for (element in elements) {
        buffer.append("\tat ")
        buffer.append(element.toString())
        buffer.append("\n")
    }
    return buffer.toString()
}

private fun getTargetStackTraceElement(): StackTraceElement? {
    var targetElement: StackTraceElement? = null
    var shouldTrace = false
    val elements = Thread.currentThread().stackTrace
    for (e in elements) {
        val isLogMethod = e.className == "com.souche.app.iov.core.support.util.L"
        if (shouldTrace && !isLogMethod) {
            targetElement = e
            break
        }
        shouldTrace = isLogMethod
    }
    return targetElement
}

private fun getTargetPath(): String {
    val element = getTargetStackTraceElement()
    return "(" + element?.fileName + ":" + element?.lineNumber + ")"
}