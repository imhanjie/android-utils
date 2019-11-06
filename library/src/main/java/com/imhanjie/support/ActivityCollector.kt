package com.imhanjie.support

import android.app.Activity
import java.util.*

/**
 * Description
 *
 * @date    2019-09-26
 * @author  hanjie
 */

object ActivityCollector {

    private val activities: ArrayList<Activity> = ArrayList()

    /**
     * add
     */
    @JvmStatic
    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

    /**
     * remove
     */
    @JvmStatic
    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

    @JvmStatic
    fun finishAll() {
        for (activity in activities) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
    }

}