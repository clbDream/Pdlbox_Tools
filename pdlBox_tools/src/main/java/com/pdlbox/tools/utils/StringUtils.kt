package com.pdlbox.tools.utils

import java.util.*


/**
 * 字符串工具类
 */
object StringUtils {

    /**
     * 随机的字符串集合
     */
    private var strList = ArrayList<String>()
    private var random = Random()

    fun init() {
        initStrList()
    }

    /**
     * 初始化字符串集合
     */
    private fun initStrList() {
        var begin = 97
        //生成小写字母,并加入集合
        for (i in begin until begin + 26) {
            strList.add(i.toChar().toString() + "")
        }
        //生成大写字母,并加入集合
        begin = 65
        for (i in begin until begin + 26) {
            strList.add(i.toChar().toString() + "")
        }
        //将0-9的数字加入集合
        for (i in 0..9) {
            strList.add(i.toString() + "")
        }
    }

    /**
     * 判断内容是否为空
     */
    fun isEmpty(content: String?): Boolean {
        return content.isNullOrEmpty()
    }

    /**
     * 判断内容是否为空格或空
     */
    fun isBlank(content: String?): Boolean {
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

    /**
     * 将给定字符串中给定的区域的字符转换成小写
     *
     * @param str 给定字符串中
     * @param beginIndex 开始索引（包括）
     * @param endIndex 结束索引（不包括）
     * @return 新的字符串
     */
    fun toLowerCase(str: String, beginIndex: Int, endIndex: Int): String? {
        return str.replaceFirst(
            str.substring(beginIndex, endIndex).toRegex(),
            str.substring(beginIndex, endIndex)
                .lowercase(Locale.getDefault())
        )
    }

    /**
     * 将给定字符串中给定的区域的字符转换成大写
     *
     * @param str 给定字符串中
     * @param beginIndex 开始索引（包括）
     * @param endIndex 结束索引（不包括）
     * @return 新的字符串
     */
    fun toUpperCase(str: String, beginIndex: Int, endIndex: Int): String? {
        return str.replaceFirst(
            str.substring(beginIndex, endIndex).toRegex(),
            str.substring(beginIndex, endIndex)
                .uppercase(Locale.getDefault())
        )
    }

    /**
     * 将给定字符串的首字母转为小写
     *
     * @param str 给定字符串
     * @return 新的字符串
     */
    fun firstLetterToLowerCase(str: String): String? {
        return toLowerCase(str, 0, 1)
    }

    /**
     * 将给定字符串的首字母转为大写
     *
     * @param str 给定字符串
     * @return 新的字符串
     */
    fun firstLetterToUpperCase(str: String): String? {
        return toUpperCase(str, 0, 1)
    }

    /**
     * 替换字符串中指定字符
     * @param str 原字符串
     * @param oldStr 被替换的字符串
     * @param newStr 要替换的字符串
     * @return 替换后的字符串
     */
    fun replace(str: String, oldStr: String, newStr: String): String {
        return str.replace(oldStr, newStr)
    }

    /**
     * 随机生成指定长度的字符串(数字加字母)
     * @param length 指定长度
     */
    fun generateRandomStrNumberAndLetter(length: Int): String {
        if (length<=0){
            return ""
        }
        val sb = StringBuffer()
        for (i in 0 until length) {
            val size: Int = strList.size
            val nextInt = random.nextInt(size)
            val randomStr: String = strList[nextInt]
            sb.append(randomStr)
        }
        return sb.toString()
    }

    /**
     * 随机生成指定长度的字符串(中文)
     * @param length 指定长度
     */
    fun generateRandomStrChinese(length: Int): String {
        if (length<=0){
            return ""
        }
        val sbu = StringBuffer()
        for (i in 0 until length) {
            val result = (0x4e00 + (Math.random() * (0x9fa5 - 0x4e00 + 1)).toInt()).toChar()
            sbu.append(result)
        }
        return sbu.toString()
    }
}