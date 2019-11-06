package com.imhanjie.support.sample

import android.app.Application
import com.imhanjie.support.AndroidUtils
import com.imhanjie.support.e

/**
 * Description
 *
 * @date    2019-11-06
 * @author  hanjie
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidUtils.install(this, BuildConfig.DEBUG)
        e("asdasdasd")
    }

}