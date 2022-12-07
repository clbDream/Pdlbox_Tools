package com.pdlbox.tools

import android.app.Activity
import android.app.Application
import android.os.Bundle
import java.util.*


object UtilsActivityLifecycleImpl: Application.ActivityLifecycleCallbacks {

    private val mActivityList = LinkedList<Activity>()

    fun init(app: Application) {
        app.registerActivityLifecycleCallbacks(this)
    }

    fun unInit(app: Application) {
        mActivityList.clear()
        app.unregisterActivityLifecycleCallbacks(this)
    }

    override fun onActivityCreated(p0: Activity, p1: Bundle?) {
        
    }

    override fun onActivityStarted(p0: Activity) {
        
    }

    override fun onActivityResumed(p0: Activity) {
        
    }

    override fun onActivityPaused(p0: Activity) {
        
    }

    override fun onActivityStopped(p0: Activity) {
        
    }

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
        
    }

    override fun onActivityDestroyed(p0: Activity) {
        
    }
}