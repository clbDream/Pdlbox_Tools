package com.pdlbox.tools

import android.app.Application




object UtilsBridge {

    fun init(app: Application) {
        UtilsActivityLifecycleImpl.init(app)
    }

    fun unInit(app: Application) {
        UtilsActivityLifecycleImpl.unInit(app)
    }

    fun preLoad() {

    }
}