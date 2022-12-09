package com.pdlbox.tools.utils

import android.util.Log
import com.pdlbox.tools.BuildConfig

object LogUtils {
    var logEnable = BuildConfig.DEBUG // 是否需要打印bug

    /**
     * 设置是否需要打印日志
     */
    fun setNeedLog(showLog: Boolean) {
        logEnable = showLog
    }

    private val TAG = "Pdlbox"

    // 下面四个是默认tag的函数  
    fun i(msg: String?) {
        if (logEnable) Log.i(TAG, msg!!)
    }

    fun d(msg: String?) {
        if (logEnable) Log.d(TAG, msg!!)
    }

    fun e(msg: String?) {
        if (logEnable) Log.e(TAG, msg!!)
    }

    fun v(msg: String?) {
        if (logEnable) Log.v(TAG, msg!!)
    }

    // 下面是传入自定义tag的函数  
    fun i(tag: String?, msg: String?) {
        if (logEnable) Log.i(tag, msg!!)
    }

    fun d(tag: String?, msg: String?) {
        if (logEnable) Log.i(tag, msg!!)
    }

    fun e(tag: String?, msg: String?) {
        if (logEnable) Log.i(tag, msg!!)
    }

    fun v(tag: String?, msg: String?) {
        if (logEnable) Log.i(tag, msg!!)
    }
}