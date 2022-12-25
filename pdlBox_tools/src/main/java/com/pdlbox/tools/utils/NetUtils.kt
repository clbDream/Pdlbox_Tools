package com.pdlbox.tools.utils

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build

/**
 * 跟网络相关的工具类
 *
 */
object NetUtils {
    /**
     * 判断网络是否连接
     *
     * @param context
     * @return
     */
    fun isConnected(context: Context): Boolean {
        val connectivity = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connectivity.activeNetworkInfo
        if (null != info && info.isConnected) {
            if (info.state == NetworkInfo.State.CONNECTED) {
                return true
            }
        }
        return false
    }

    /**
     * 判断是否是wifi连接
     */
//    fun isWifi(context: Context): Boolean {
//        val cm = context
//            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        return cm.activeNetworkInfo!!.type == ConnectivityManager.TYPE_WIFI
//    }

    /**
     * 打开网络设置界面
     */
    fun openSetting(activity: Activity) {
        val intent = Intent("/")
        val cm = ComponentName(
            "com.android.settings",
            "com.android.settings.WirelessSettings"
        )
        intent.component = cm
        intent.action = "android.intent.action.VIEW"
        activity.startActivityForResult(intent, 0)
    }

    /**
     * 判断是否是wifi连接
     */
    fun isWifi(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val nc = cm.getNetworkCapabilities(cm.activeNetwork)
            nc?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) == true
        } else {
            cm.activeNetworkInfo!!.type == ConnectivityManager.TYPE_WIFI
        }
    }

    /**
     * 判断是否是移动网络
     */
    fun isMobilNet(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val nc = cm.getNetworkCapabilities(cm.activeNetwork)
            nc?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) == true
        } else {
            cm.activeNetworkInfo!!.type == ConnectivityManager.TYPE_MOBILE
        }
    }
}