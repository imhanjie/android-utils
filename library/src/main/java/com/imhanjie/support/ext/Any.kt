package com.imhanjie.support.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment

inline fun <reified T> Any.toActivity(
    bundle: Bundle? = null,
    requestCode: Int = -1,
    noinline block: ((intent: Intent) -> Unit)? = null
) {
    val ctx = this as? Context
        ?: if (this is Fragment) this.context else throw IllegalArgumentException("接收者对象错误")
    val intent = Intent(ctx, T::class.java)
    bundle?.let { intent.putExtras(it) }
    block?.invoke(intent)
    when (this) {
        is Activity -> this.startActivityForResult(intent, requestCode)
        is Fragment -> this.startActivityForResult(intent, requestCode)
        is Context -> this.startActivity(intent)
    }
}