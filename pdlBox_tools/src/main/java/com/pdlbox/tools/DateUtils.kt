package com.pdlbox.tools

import java.text.SimpleDateFormat
import java.util.*

/**
 * 日期工具类
 */
object DateUtils {

    const val DATE_TYPE_1 = "yyyy年MM月dd日"
    const val DATE_TYPE_2 = "yyyy/MM/dd"

    /**
     * 格式化时间戳为日期字符串
     * @param timeMillis 要格式化的时间戳(毫秒类型)
     * @param type 格式化类型
     */
    fun formatDateToString(timeMillis: Long, type: String = DATE_TYPE_1): CharSequence {
        return SimpleDateFormat(type).format(Date(timeMillis))
    }

}