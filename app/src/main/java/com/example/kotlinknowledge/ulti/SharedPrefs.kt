package com.example.kotlinknowledge.ulti;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.kotlinknowledge.MainApplication;
object SharedPrefs {
    private const val PREFS_NAME = "share_prefs"
    val sharedPreferences: SharedPreferences? by lazy {
        MainApplication.self()?.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    inline fun <reified T> get(key: String, defaultValue: T): T {
        return when (T::class) {
            String::class -> sharedPreferences?.getString(key, defaultValue as? String ?: "") as T
            Boolean::class -> sharedPreferences?.getBoolean(key, defaultValue as? Boolean ?: false) as T
            Float::class -> sharedPreferences?.getFloat(key, defaultValue as? Float ?: 0f) as T
            Int::class -> sharedPreferences?.getInt(key, defaultValue as? Int ?: 0) as T
            Long::class -> sharedPreferences?.getLong(key, defaultValue as? Long ?: 0L) as T
            else -> throw IllegalArgumentException("Unsupported type")
        }
    }

    fun <T> put(key: String, data: T) {
        with(sharedPreferences?.edit()) {
            when (data) {
                is String -> this?.putString(key, data)
                is Boolean -> this?.putBoolean(key, data)
                is Float -> this?.putFloat(key, data)
                is Int -> this?.putInt(key, data)
                is Long -> this?.putLong(key, data)
                else -> throw IllegalArgumentException("Unsupported type")
            }
            this?.apply()
        }
    }

    fun clear() {
        sharedPreferences?.edit()?.clear()?.apply()
    }
}
