package com.pdlbox.tools.utils

import java.util.regex.Pattern

/**
 * 正则验证工具类
 */
object RegexUtils {

    /**
     * 判断是否匹配正则
     */
    fun isMatch(regex: String, input: CharSequence?): Boolean {
        return input != null && input.isNotEmpty() && Pattern.matches(regex, input)
    }

    /**
     * 验证是否是手机号(严格)
     */
    fun isPhoneNumberStrict(input: String): Boolean {
        return isMatch("^1[3|4|5|6|7|8][0-9]\\d{8}$", input)
    }

    /**
     * 验证是否是手机号(宽松)
     */
    fun isPhoneNumberSimple(input: String): Boolean {
        return input.startsWith("1") && input.length == 11
    }

    /**
     * 验证输入的名字是否为“中文”或者是否包含“·”
     */
    fun isLegalName(input: String): Boolean {
        if (input.contains("·") || input.contains("&＃8226;")) {
            return isMatch("^[\\u4e00-\\u9fa5]+[·&＃8226;][\\u4e00-\\u9fa5]+$", input)
        } else {
            return isMatch("^[\\u4e00-\\u9fa5]+$", input)
        }
    }

    /**
     * 验证是否是身份证号
     */
    fun isLegalId(input: String): Boolean {
        return isMatch("\\d{17}[0-9Xx]|\\d{15}", input)
    }

    /**
     * 验证是否是邮箱
     */
    fun isEmail(input: String): Boolean {
        val regex =
            "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}"
        return isMatch(regex, input)
    }

    /**
     * 判断是不是中文
     */
    fun matchChinese(input: String): Boolean {
        return isMatch("[\\u4e00-\\u9fa5]+", input)
    }

    /**
     * 判断是不是时间
     */
    fun isTime(input: String): Boolean {
        return isMatch("([01]?\\d|2[0-3]):[0-5]?\\d:[0-5]?\\d", input)
    }

    /**
     * 判断是不是ipv4
     */
    fun isIpV4(input: String): Boolean {
        return isMatch("\\d{0,3}\\.\\d{0,3}\\.\\d{0,3}\\.\\d{0,3}", input)
    }

    /**
     * 判断是不是日期
     */
    fun isDate(input: String): Boolean {
        return isMatch("(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)",
            input)
    }

    /**
     * 判断是否是车牌号
     */
    fun isCarNumber(input: String): Boolean {
        return isMatch("(([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z](([0-9]{5}[DF])|([DF]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z][A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳使领]))",
            input)
    }
}