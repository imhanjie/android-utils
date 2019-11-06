package com.imhanjie.support

import android.content.Context
import android.content.SharedPreferences

/**
 * Description
 *
 * @date    2019-09-26
 * @author  hanjie
 */

class PreferencesManager private constructor(context: Context, fileName: String) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor

    init {
        this.editor = preferences.edit()
    }

    fun putInt(key: String, value: Int) {
        editor.putInt(key, value)
        editor.apply()
    }

    fun getInt(key: String, defValue: Int): Int {
        return preferences.getInt(key, defValue)
    }

    fun putBoolean(key: String, value: Boolean) {
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBoolean(key: String, defValue: Boolean): Boolean {
        return preferences.getBoolean(key, defValue)
    }

    fun putFloat(key: String, value: Float) {
        editor.putFloat(key, value)
        editor.apply()
    }

    fun getFloat(key: String, defValue: Float): Float {
        return preferences.getFloat(key, defValue)
    }

    fun putLong(key: String, value: Long) {
        editor.putLong(key, value)
        editor.apply()
    }

    fun getLong(key: String, defValue: Long): Long {
        return preferences.getLong(key, defValue)
    }

    fun putString(key: String, value: String) {
        editor.putString(key, value)
        editor.apply()
    }

    fun getString(key: String, defValue: String): String {
        return preferences.getString(key, defValue)!!
    }

    fun clearAll() {
        editor.clear().apply()
    }

    companion object {
        @Volatile
        private var managerMap: MutableMap<String, PreferencesManager> = mutableMapOf()

        @JvmStatic
        fun getInstance(fileName: String): PreferencesManager {
            if (managerMap[fileName] === null) {
                synchronized(PreferencesManager::class.java) {
                    if (managerMap[fileName] === null) {
                        managerMap[fileName] =
                            PreferencesManager(AndroidUtils.INSTANCE, fileName)
                    }
                }
            }
            return managerMap[fileName]!!
        }
    }

}