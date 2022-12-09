package com.pdlbox.tools.utils

import android.widget.Toast
import com.pdlbox.tools.Utils

/**
 * 吐司工具类
 */
object ToastUtils {

    //是否显示Toast
    var isShow = true

    /**
     * 短时间显示Toast
     *
     * @param message
     */
    fun showShort( message: CharSequence?) {
        if (isShow) Toast.makeText(Utils.getApp(), message, Toast.LENGTH_SHORT).show()
    }

    /**
     * 短时间显示Toast
     *
     * @param message
     */
    fun showShort( message: Int) {
        if (isShow) Toast.makeText(Utils.getApp(), message, Toast.LENGTH_SHORT).show()
    }

    /**
     * 长时间显示Toast
     *
     * @param message
     */
    fun showLong( message: CharSequence?) {
        if (isShow) Toast.makeText(Utils.getApp(), message, Toast.LENGTH_LONG).show()
    }

    /**
     * 长时间显示Toast
     *
     * @param message
     */
    fun showLong( message: Int) {
        if (isShow) Toast.makeText(Utils.getApp(), message, Toast.LENGTH_LONG).show()
    }

//    /**
//     * 自定义显示Toast时间
//     *
//     * @param message
//     * @param duration
//     */
//    fun show( message: CharSequence?, duration: Int) {
//        if (isShow) Toast.makeText(Utils.getApp(), message, duration).show()
//    }
//
//    /**
//     * 自定义显示Toast时间
//     *
//     * @param message
//     * @param duration
//     */
//    fun show( message: Int, duration: Int) {
//        if (isShow) Toast.makeText(Utils.getApp(), message, duration).show()
//    }
}