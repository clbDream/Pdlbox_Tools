package com.pdlbox.tools.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Build
import com.pdlbox.tools.Utils

/**
 * 剪切板
 */
object ClipboardUtils {

    /**
     * 复制文本到剪切板
     */
    fun copyText(text: String) {
        //获取剪切板管理器
        val cm: ClipboardManager =
            Utils.getApp().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        //设置内容到剪切板
        cm.setPrimaryClip(ClipData.newPlainText(null, text))
    }

    /**
     * 获取剪切板文本
     */
    fun getText(): String {
        //获取剪切板管理器
        val cm: ClipboardManager =
            Utils.getApp().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        return if (cm.hasPrimaryClip() && cm.primaryClip != null) {
            cm.primaryClip?.getItemAt(0)?.text.toString()
        } else {
            ""
        }
    }

    /**
     * 清楚剪切板
     */
    fun clear() {
        val cm: ClipboardManager =
            Utils.getApp().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            cm.clearPrimaryClip()
        } else {
            cm.setPrimaryClip(ClipData.newPlainText(null, null))
        }
    }
}