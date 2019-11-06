@file:JvmName("KeyboardHelper")

package com.imhanjie.support

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import java.lang.reflect.Method

/**
 * Description
 *
 * @date    2019-09-26
 * @author  hanjie
 */

/**
 * 隐藏软键盘
 */
fun hideKeyBoard(context: Context, view: View) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

/**
 * 显示软键盘
 */
fun showKeyBoard(context: Context, view: View) {
    view.apply {
        isFocusable = true
        isFocusableInTouchMode = true
        requestFocus()
        findFocus()
    }
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS)
}

/**
 * 屏蔽EditText软键盘并保证游标正常显示
 */
fun disableSoftInputAndKeepCursor(editText: EditText) {
    val cls = EditText::class.java
    var method: Method
    try {
        method = cls.getMethod("setShowSoftInputOnFocus", Boolean::class.javaPrimitiveType)
        method.isAccessible = true
        method.invoke(editText, false)
    } catch (ignore: Exception) {
    }

    try {
        method = cls.getMethod("setSoftInputShownOnFocus", Boolean::class.javaPrimitiveType)
        method.isAccessible = true
        method.invoke(editText, false)
    } catch (ignore: Exception) {
    }

}