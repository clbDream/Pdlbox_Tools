package com.pdlbox.tools.utils

import android.util.Base64


/**
 * 编码工具类
 */
object EncodeUtils {

    /**
     * base64编码
     */
    fun encodeBase64(str: String): String {
        if (str.isBlank()) {
            return ""
        }
        return String(Base64.encode(str.toByteArray(Charsets.UTF_8), Base64.DEFAULT))
    }

    /**
     * Base64解码
     */
    fun decodeBase64(str: String): String {
        if (str.isBlank()) {
            return ""
        }
        return String(Base64.decode(str.toByteArray(Charsets.UTF_8), Base64.DEFAULT))
    }
}