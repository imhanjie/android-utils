package com.imhanjie.support.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment

inline fun <reified T> Any.toActivity(
    extraMap: Map<String, Any>? = null,
    requestCode: Int = -1,
    noinline block: ((intent: Intent) -> Unit)? = null
) {
    val ctx = this as? Context
        ?: if (this is Fragment) this.context else throw IllegalArgumentException("接收者对象错误")
    val intent = Intent(ctx, T::class.java)
    extraMap?.let { intent.putExtrasMap(it) }
    block?.invoke(intent)
    when (this) {
        is Activity -> this.startActivityForResult(intent, requestCode)
        is Fragment -> this.startActivityForResult(intent, requestCode)
        is Context -> this.startActivity(intent)
    }
}