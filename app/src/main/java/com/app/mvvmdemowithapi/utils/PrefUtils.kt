package com.app.mvvmdemowithapi.utils

import android.content.Context
import android.content.SharedPreferences
import com.app.mvvmdemowithapi.R


class PrefUtils(context: Context) {

    private lateinit var prefs: SharedPreferences
    init {
        getPrefs(context)
    }

    private fun getPrefs(context: Context): SharedPreferences {
        prefs = context.getSharedPreferences(context.getString(R.string.app_name),
            Context.MODE_PRIVATE
        )
        return context.getSharedPreferences(context.getString(R.string.app_name),
            Context.MODE_PRIVATE
        )
    }

    fun removePref(key: String) {
        prefs.edit().remove(key).apply()
    }

    /**
     * Store integer value
     * */
    fun putInt(key: String, value: Int) {
        prefs.edit().putInt(key, value).apply()
    }

    /**
     * Retrieve integer value
     * */
    fun getInt(key: String): Int {
        return prefs.getInt(key, 0)
    }


    /**
     * Store string value
     * */
    fun putString(key: String, value: String) {
        prefs.edit().putString(key, value).apply()
    }


    /**
     * Retrieve string value
     * */
    fun getString(key: String): String? {
        return prefs.getString(key, "")
    }

    /**
     * Store boolean value
     * */
    fun putBoolean(key: String, value: Boolean) {
        prefs.edit().putBoolean(key, value).apply()
    }

    /**
     * Retrieve boolean value
     * */
    fun getBoolean(key: String): Boolean {
        return prefs.getBoolean(key, false)
    }

    fun hasPref(key: String): Boolean {
        return prefs.contains(key)
    }

}