package com.pdlbox.tools.utils

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.pm.PackageManager.NameNotFoundException


/**
 * 跟App相关的辅助类
 *
 */
object AppUtils {
    /**
     * 获取应用程序名称
     */
    fun getAppName(context: Context): String? {
        try {
            val packageManager: PackageManager = context.getPackageManager()
            val packageInfo: PackageInfo = packageManager.getPackageInfo(
                context.getPackageName(), 0)
            val labelRes = packageInfo.applicationInfo.labelRes
            return context.getResources().getString(labelRes)
        } catch (e: NameNotFoundException) {
            e.printStackTrace()
        }
        return null
    }

    /**
     * 获取应用程序版本名称信息
     *
     * @param context
     * @return 当前应用的版本名称
     */
    fun getVersionName(context: Context): String? {
        try {
            val packageManager: PackageManager = context.getPackageManager()
            val packageInfo: PackageInfo = packageManager.getPackageInfo(
                context.getPackageName(), 0)
            return packageInfo.versionName
        } catch (e: NameNotFoundException) {
            e.printStackTrace()
        }
        return null
    }
    /**
     * 获取应用程序包名
     *
     * @param context
     * @return 当前应用的版本名称
     */
    fun getPackageName(context: Context): String? {
        try {
            val packageManager: PackageManager = context.getPackageManager()
            val packageInfo: PackageInfo = packageManager.getPackageInfo(
                context.getPackageName(), 0)
            return packageInfo.packageName
        } catch (e: NameNotFoundException) {
            e.printStackTrace()
        }
        return null
    }

}