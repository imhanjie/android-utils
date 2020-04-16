package com.imhanjie.support

import android.app.Application

/**
 * Description
 *
 * @date    2019-11-05
 * @author  hanjie
 */


object AndroidUtils {

    internal lateinit var APP: Application
    internal var isDebug = false

    fun install(app: Application, debug: Boolean) {
        APP = app
        isDebug = debug
    }

}

