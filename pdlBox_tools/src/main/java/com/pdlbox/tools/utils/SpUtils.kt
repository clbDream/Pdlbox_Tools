package com.pdlbox.tools.utils

import android.content.Context
import android.content.SharedPreferences.Editor
import com.pdlbox.tools.Utils
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

/**
 * Sp存储
 */
object SpUtils {

    /**
     * @param fileName 保存在手机里面的文件名
     * @param key
     * @param object
     */
    fun put(fileName: String, key: String, content: String) {
        val sp = Utils.getApp().getSharedPreferences(fileName,
            Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString(key, content)
        SharedPreferencesCompat.apply(editor)
    }

    /**
     * @param fileName 保存在手机里面的文件名
     * @param key
     * @param object
     */
    fun put(fileName: String, key: String, content: Int) {
        val sp = Utils.getApp().getSharedPreferences(fileName,
            Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putInt(key, content)
        SharedPreferencesCompat.apply(editor)
    }

    /**
     * @param fileName 保存在手机里面的文件名
     * @param key
     * @param object
     */
    fun put(fileName: String, key: String, content: Boolean) {
        val sp = Utils.getApp().getSharedPreferences(fileName,
            Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putBoolean(key, content)
        SharedPreferencesCompat.apply(editor)
    }

    /**
     * @param fileName 保存在手机里面的文件名
     * @param key
     * @param object
     */
    fun put(fileName: String, key: String, content: Long) {
        val sp = Utils.getApp().getSharedPreferences(fileName,
            Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putLong(key, content)
        SharedPreferencesCompat.apply(editor)
    }

    /**
     * @param fileName 保存在手机里面的文件名
     * @param key
     * @param object
     */
    fun put(fileName: String, key: String, content: Float) {
        val sp = Utils.getApp().getSharedPreferences(fileName,
            Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putFloat(key, content)
        SharedPreferencesCompat.apply(editor)
    }


    /**
     *
     * @param fileName 保存在手机里面的文件名
     * @param key
     * @return
     */
    fun getString(fileName: String, key: String, defaultValue: String = ""): String? {
        val sp = Utils.getApp().getSharedPreferences(fileName,
            Context.MODE_PRIVATE)
        return sp.getString(key, defaultValue)
    }

    /**
     *
     * @param fileName 保存在手机里面的文件名
     * @param key
     * @return
     */
    fun getBoolean(fileName: String, key: String, defaultValue: Boolean = false): Boolean {
        val sp = Utils.getApp().getSharedPreferences(fileName,
            Context.MODE_PRIVATE)
        return sp.getBoolean(key, defaultValue)
    }

    /**
     *
     * @param fileName 保存在手机里面的文件名
     * @param key
     * @return
     */
    fun getFloat(fileName: String, key: String, defaultValue: Float = -1F): Float {
        val sp = Utils.getApp().getSharedPreferences(fileName,
            Context.MODE_PRIVATE)
        return sp.getFloat(key, defaultValue)
    }


    /**
     *
     * @param fileName 保存在手机里面的文件名
     * @param key
     * @return
     */
    fun getInt(fileName: String, key: String, defaultValue: Int = -1): Int {
        val sp = Utils.getApp().getSharedPreferences(fileName,
            Context.MODE_PRIVATE)
        return sp.getInt(key, defaultValue)
    }


    /**
     *
     * @param fileName 保存在手机里面的文件名
     * @param key
     * @return
     */
    fun getLong(fileName: String, key: String, defaultValue: Long = -1L): Long {
        val sp = Utils.getApp().getSharedPreferences(fileName,
            Context.MODE_PRIVATE)
        return sp.getLong(key, defaultValue)
    }

    /**
     * 移除某个key值已经对应的值
     * @param fileName 保存在手机里面的文件名
     * @param key
     */
    fun remove(fileName: String, key: String?) {
        val sp = Utils.getApp().getSharedPreferences(fileName,
            Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.remove(key)
        SharedPreferencesCompat.apply(editor)
    }

    /**
     * 清除所有数据
     * @param fileName 保存在手机里面的文件名
     */
    fun clear(fileName: String) {
        val sp = Utils.getApp().getSharedPreferences(fileName,
            Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.clear()
        SharedPreferencesCompat.apply(editor)
    }


    /**
     * 查询某个key是否已经存在
     * @param fileName 保存在手机里面的文件名
     * @param key
     * @return
     */
    fun contains(fileName: String, key: String?): Boolean {
        val sp = Utils.getApp().getSharedPreferences(fileName,
            Context.MODE_PRIVATE)
        return sp.contains(key)
    }

    /**
     * 返回所有的键值对
     *
     * @param fileName 保存在手机里面的文件名
     * @return
     */
    fun getAll(fileName: String): Map<String, *> {
        val sp = Utils.getApp().getSharedPreferences(fileName,
            Context.MODE_PRIVATE)
        return sp.all
    }

    /**
     * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
     *
     * @author zhy
     */
    private object SharedPreferencesCompat {
        private val sApplyMethod = findApplyMethod()

        /**
         * 反射查找apply的方法
         *
         * @return
         */
        private fun findApplyMethod(): Method? {
            try {
                val clz: Class<*> = Editor::class.java
                return clz.getMethod("apply")
            } catch (e: NoSuchMethodException) {
            }
            return null
        }

        /**
         * 如果找到则使用apply执行，否则使用commit
         *
         * @param editor
         */
        fun apply(editor: Editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor)
                    return
                }
            } catch (e: IllegalArgumentException) {
            } catch (e: IllegalAccessException) {
            } catch (e: InvocationTargetException) {
            }
            editor.commit()
        }
    }
}