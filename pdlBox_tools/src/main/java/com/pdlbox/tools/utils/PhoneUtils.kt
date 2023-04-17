package com.pdlbox.tools.utils

/**
 * @ClassName: PhoneUtils
 * @Description: 手机号相关工具类
 * @Author: 常利兵
 * @Date: 2023/4/17 15:44
 **/
object PhoneUtils {

    /**
     * 手机号隐藏部分号码(非手机号原样返回）
     */
    fun phoneNumberHide(mobile:String): String {
        val PHONE_BLUR_REGEX = "(\\d{3})\\d{4}(\\d{4})"
        /** * 手机号脱敏替换正则  */
        val PHONE_BLUR_REPLACE_REGEX = "$1****$2"
        /** * 手机号格式校验 * @param phone * @return  */
        return if (mobile.isEmpty() || mobile.length != 11) {
            mobile
        } else mobile.replace(PHONE_BLUR_REGEX.toRegex(), PHONE_BLUR_REPLACE_REGEX)
    }

}