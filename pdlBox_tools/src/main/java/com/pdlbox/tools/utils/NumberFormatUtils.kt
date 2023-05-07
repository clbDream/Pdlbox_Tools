package com.pdlbox.tools.utils

import java.math.BigDecimal

/**
 * @ClassName: NumberFormatUtils
 * @Description: 数字格式化工具类
 * @Author: 常利兵
 * @Date: 2023/4/18 18:53
 **/
object NumberFormatUtils {

    /**
     * 数字格式化(保留1位小数）
     */
    fun numberFormat(i: Long): String {
        return if (i < 1000) {
            (i.toInt()).toString()
        } else if (i in 1000..9999) {
            val tempNum = (i / 1000F).toString()
            tempNum.substring(0, tempNum.indexOf(".", 0) + 2) + "k"
        } else if (i in 10000..9999999) {
            val tempNum = (i / 10000F).toString()
            tempNum.substring(0, tempNum.indexOf(".", 0) + 2) + "w"
            String.format("%.1f", i / 10000F) + "w"
        } else {
            //kw
            val tempNum = (i / 10000000F).toString()
            tempNum.substring(0, tempNum.indexOf(".", 0) + 2) + "kw"
        }
    }

    /**
     * 保留两位小数(去掉最后的0）
     */
    fun keepTwoDecimalPlaces(number: String?): String {
        return customDecimalPlaces(number, 2)
    }

    /**
     * 自定义小数位数
     */
    fun customDecimalPlaces(number: String?, size: Int): String {
        try {
            var number = number ?: return ""
            if (number.indexOf(".") > 0) {
                //正则表达
                number = number.replace("0+?$".toRegex(), "") //去掉后面无用的零
                number = number.replace("[.]$".toRegex(), "") //如小数点后面全是零则去掉小数点
            }
            return if (number.indexOf(".") > 0) {
                val b = BigDecimal(number)
                b.setScale(size, BigDecimal.ROUND_HALF_UP).toDouble().toString()
            } else {
                number
            }
        } catch (e: Exception) {
            return "0"
        }
    }
}