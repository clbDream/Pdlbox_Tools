package com.pdlbox.tools

import com.pdlbox.tools.utils.TimeUtils
import org.junit.Assert
import org.junit.Test

class TimeTest {

    /**
     * 是否闰年
     */
    @Test
    fun isItALeapYear(){
        Assert.assertEquals(true,TimeUtils.isItALeapYear(2012))
        Assert.assertEquals(false,TimeUtils.isItALeapYear(2011))
    }
}