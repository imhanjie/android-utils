package com.imhanjie.support

import android.app.Application

/**
 * Description
 *
 * @date    2019-11-05
 * @author  hanjie
 */


class AndroidUtils {

    companion object {
        internal lateinit var INSTANCE: Application
        internal var isDebug = false

        @JvmStatic
        fun install(app: Application, debug: Boolean) {
            INSTANCE = app
            isDebug = debug
        }
    }

}

