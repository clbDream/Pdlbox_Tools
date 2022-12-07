package com.pdlbox.tools

/**
 * 转换工具类
 */
object ConversionUtils {

    fun dp2Px(dpValue:Float): Int {
        return SizeUtils.dp2px(dpValue)
    }

    fun px2dp(pxValue:Float): Int {
        return SizeUtils.px2dp(pxValue)
    }

    fun sp2px(spValue:Float): Int {
        return SizeUtils.sp2px(spValue)
    }

    fun px2sp(pxValue:Float): Int {
        return SizeUtils.px2sp(pxValue)
    }
}