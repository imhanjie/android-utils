package com.imhanjie.support

import android.content.ClipboardManager
import android.content.Context

/**
 * Description
 *
 * @date    2019-11-06
 * @author  hanjie
 */

fun copyToClipboard(content: String?) {
    val clipboardManager =
        AndroidUtils.INSTANCE.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    clipboardManager.text = content
}