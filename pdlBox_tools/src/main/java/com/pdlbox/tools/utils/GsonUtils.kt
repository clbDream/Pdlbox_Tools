package com.pdlbox.tools.utils

import com.google.gson.Gson


object GsonUtils {

    private val mGson = Gson()

    fun getGson(): Gson {
        return mGson
    }

    /**
     * 对象转json字符串
     */
    fun toJson(`object`: Any): String {
        return mGson.toJson(`object`)
    }

    /**
     * json字符串转对象
     */
    fun <T> fromJson(json: String?, type: Class<T>): T? {
        return mGson.fromJson(json, type)
    }

}