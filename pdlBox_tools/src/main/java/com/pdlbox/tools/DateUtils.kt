package com.pdlbox.tools

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


/**
 * 日期工具类
 */
object DateUtils {

    const val DATE_TYPE_1 = "yyyy年MM月dd日"
    const val DATE_TYPE_2 = "yyyy/MM/dd"
    const val DATE_TYPE_3 = "yyyy.MM.dd"
    const val DATE_TYPE_4 = "MM.dd"
    const val DATE_TYPE_5 = "MM月dd日"
    const val DATE_TYPE_6 = "MM/dd"

    private val SDF_THREAD_LOCAL: ThreadLocal<HashMap<String, SimpleDateFormat>> =
        object : ThreadLocal<HashMap<String, SimpleDateFormat>>() {
            override fun initialValue(): HashMap<String, SimpleDateFormat> {
                return HashMap()
            }
        }


    @SuppressLint("SimpleDateFormat")
    fun getSafeDateFormat(pattern: String): SimpleDateFormat {
        val sdfMap: HashMap<String, SimpleDateFormat>? = SDF_THREAD_LOCAL.get()
        var simpleDateFormat = sdfMap?.get(pattern)
        if (simpleDateFormat == null) {
            simpleDateFormat = SimpleDateFormat(pattern)
            sdfMap?.set(pattern, simpleDateFormat)
        }
        return simpleDateFormat
    }

    /**
     * 格式化时间戳为日期字符串
     * @param timeMillis 要格式化的时间戳(毫秒类型)
     * @param pattern 格式化类型
     * @return 日期字符串
     */
    fun millis2String(timeMillis: Long, pattern: String = DATE_TYPE_1): String {
        return millis2String(timeMillis, getSafeDateFormat(pattern))
    }

    /**
     * 格式化时间戳为日期字符串
     * @param timeMillis 要格式化的时间戳(毫秒类型)
     * @param format The format
     * @return 日期字符串
     */
    fun millis2String(timeMillis: Long, format: SimpleDateFormat): String {
        return try {
            format.format(Date(timeMillis))
        } catch (e: ParseException) {
            "-1"
        }
    }

    /**
     * 格式化日期字符串为时间戳
     * @param timeMillis 要格式化的时间字符串,(默认为yyyy/MM/dd)
     * @param pattern 格式化类型
     * @return 时间戳(毫秒值)
     */
    fun string2millis(time: String, pattern: String = DATE_TYPE_2): Long {
        return string2millis(time, getSafeDateFormat(pattern))
    }

    /**
     * 格式化日期字符串为时间戳
     * @param timeMillis 要格式化的日期字符串
     * @param format The format
     * @return 时间戳(毫秒值)
     */
    fun string2millis(time: String, pattern: SimpleDateFormat): Long {
        return try {
            pattern.parse(time)?.time ?: -1
        } catch (e: ParseException) {
            -1
        }
    }

}