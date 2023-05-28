package com.pdlbox.tools.utils

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


/**
 * 时间工具类
 */
object TimeUtils {
    const val DATE_TYPE_1 = "yyyy年MM月dd日 hh时mm分ss秒"
    const val DATE_TYPE_2 = "yyyy/MM/dd hh:mm:ss"
    const val DATE_TYPE_3 = "yyyy.MM.dd hh:mm:ss"
    const val DATE_TYPE_4 = "hh:mm:ss"
    const val DATE_TYPE_5 = "hh时mm分ss秒"
    const val DATE_TYPE_6 = "hh时mm分"
    const val DATE_TYPE_7 = "hh:mm"
    const val DATE_TYPE_8 = "hh.mm"

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
     * @param time 要格式化的时间字符串,(默认为yyyy/MM/dd)
     * @param pattern 格式化类型
     * @return 时间戳(毫秒值)
     */
    fun string2millis(time: String, pattern: String = DATE_TYPE_2): Long {
        return string2millis(time, getSafeDateFormat(pattern))
    }

    /**
     * 格式化日期字符串为时间戳
     * @param time 要格式化的日期字符串
     * @param format The format
     * @return 时间戳(毫秒值)
     */
    fun string2millis(time: String, format: SimpleDateFormat): Long {
        return try {
            format.parse(time)?.time ?: -1
        } catch (e: ParseException) {
            -1
        }
    }

    /**
     * 格式化时间戳为 几分钟前 本周 刚刚这种类型
     */
    fun longFormatTime(time: Long): String? {
//        var time = time
//        time = time * 1000
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //转换为日期
        val date = Date()
        date.time = time
        return if (isThisYear(date)) { //今年
            val simpleDateFormat = SimpleDateFormat("HH:mm")
            if (isToday(date)) { //今天
                val minute: Int = minutesAgo(time)
                if (minute < 60) { //1小时之内
                    if (minute <= 1) { //一分钟之内，显示刚刚
                        "刚刚"
                    } else {
                        minute.toString() + "分钟前"
                    }
                } else {
                    simpleDateFormat.format(date)
                }
            } else {
                if (isYestYesterday(date)) { //昨天，显示昨天
                    "昨天 " + simpleDateFormat.format(date)
                } else if (isThisWeek(date)) { //本周,显示周几
                    var weekday: String? = null
                    if (date.day === 1) {
                        weekday = "周一"
                    }
                    if (date.day === 2) {
                        weekday = "周二"
                    }
                    if (date.day === 3) {
                        weekday = "周三"
                    }
                    if (date.day === 4) {
                        weekday = "周四"
                    }
                    if (date.day === 5) {
                        weekday = "周五"
                    }
                    if (date.day === 6) {
                        weekday = "周六"
                    }
                    if (date.day === 0) {
                        weekday = "周日"
                    }
                    weekday + " " + simpleDateFormat.format(date)
                } else {
                    val sdf = SimpleDateFormat("MM-dd HH:mm")
                    sdf.format(date)
                }
            }
        } else {
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm")
            sdf.format(date)
        }
    }

    /**
     * 几分钟以前
     */
    private fun minutesAgo(time: Long): Int {
        return ((System.currentTimeMillis() - time) / 60000).toInt()
    }

    /**
     * 是否是今天
     */
    fun isToday(date: Date): Boolean {
        val now = Date()
        return date.year == now.year && date.month == now.month && date.date == now.date
    }

    /**
     * 是否是去年
     */
    fun isYestYesterday(date: Date): Boolean {
        val now = Date()
        return date.year == now.year && date.month == now.month && date.date + 1 == now.date
    }

    /**
     * 是否是本周
     */
    fun isThisWeek(date: Date): Boolean {
        val now = Date()
        if (date.year == now.year && date.month == now.month) {
            if (now.day - date.day < now.day && now.date - date.date > 0 && now.date - date.date < 7) {
                return true
            }
        }
        return false
    }

    /**
     * 是否是今年
     */
    fun isThisYear(date: Date): Boolean {
        val now = Date()
        return date.year == now.year
    }

    /**
     * 判断是否是闰年
     */
    fun isItALeapYear(year: Int): Boolean {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0
    }
}