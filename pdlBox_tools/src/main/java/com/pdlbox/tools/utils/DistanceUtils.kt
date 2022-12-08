package com.pdlbox.tools.utils

/**
 * 距离工具类
 */
object DistanceUtils {

    /**
     * 毫米转厘米
     */
    fun mmToCm(distanceValue: Long): Long {
        return distanceValue / 10
    }

    /**
     * 厘米转毫米
     */
    fun cmToMm(distanceValue: Long): Long {
        return distanceValue * 10
    }

    /**
     * 厘米转分米
     */
    fun cmToDecimeter(distanceValue: Long): Long {
        return distanceValue / 10
    }

    /**
     * 分米转厘米
     */
    fun decimeterToCm(distanceValue: Long): Long {
        return distanceValue * 10
    }

    /**
     * 分米转米
     */
    fun decimeterToM(distanceValue: Long): Long {
        return distanceValue / 10
    }

    /**
     * 米转分米
     */
    fun mToDecimeter(distanceValue: Long): Long {
        return distanceValue * 10
    }

    /**
     * 米转千米
     */
    fun metersToKilometers(distanceValue: Long): Long {
        return distanceValue / 1000
    }

    /**
     * 千米转米
     */
    fun kilometerToMeter(distanceValue: Long): Long {
        return distanceValue * 1000
    }
}