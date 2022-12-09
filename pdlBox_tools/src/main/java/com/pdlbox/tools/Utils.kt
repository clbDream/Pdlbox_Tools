package com.pdlbox.tools

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log


/**
 * 工具类
 */
object Utils {

    @SuppressLint("StaticFieldLeak")
    private var sApp: Application? = null

    fun init(app: Application?) {
        if (app == null) {
            Log.e("Utils", "app is null.");
            return
        }
        if (sApp == null) {
            sApp = app
            UtilsBridge.init(sApp!!)
            UtilsBridge.preLoad()
            return;
        }
        if (sApp?.equals(app)==true) return
        UtilsBridge.unInit(sApp!!);
        sApp = app
        UtilsBridge.init(sApp!!)
    }

    fun getApp(): Application {
        return sApp!!
    }
}