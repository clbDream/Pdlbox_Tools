package com.pdlbox.tools.utils

/**
 * 字符串工具类
 */
object StringUtils {

    /**
     * 判断内容是否为空
     */
    fun isEmpty(content:String?): Boolean {
        return content.isNullOrEmpty()
    }

    /**
     * 判断内容是否为空格或空
     */
    fun isBlank(content:String?): Boolean {
        return content.isNullOrBlank()
    }

    /**
     * 判断str1和str2是否相同(不区分大小写)
     *
     * @param str1 str1
     * @param str2 str2
     * @return true or false
     */
    fun equalsIgnoreCase(str1: String?, str2: String?): Boolean {
        return str1 != null && str1.equals(str2, ignoreCase = true)
    }

    /**
     * 判断字符串str1是否包含字符串str2
     *
     * @param str1 源字符串
     * @param str2 指定字符�?
     * @return true源字符串包含指定字符串，false源字符串不包含指定字符串
     */
    fun contains(str1: String?, str2: String?): Boolean {
        return str1 != null && str1.contains(str2!!)
    }
}