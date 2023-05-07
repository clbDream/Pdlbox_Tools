package com.pdlbox.tools

import com.pdlbox.tools.utils.NumberFormatUtils
import org.junit.Assert
import org.junit.Test

/**
 * @ClassName: NumberFormatTest
 * @Description:
 * @Author: 常利兵
 * @Date: 2023/4/18 19:00
 **/
class NumberFormatTest {

    @Test
    fun testNumberFormat() {
        Assert.assertEquals("1.9k", NumberFormatUtils.numberFormat(1999))
        Assert.assertEquals("1.0w", NumberFormatUtils.numberFormat(10000))
        Assert.assertEquals("9.9k", NumberFormatUtils.numberFormat(9999))
        Assert.assertEquals("999", NumberFormatUtils.numberFormat(999))
    }

    @Test
    fun keepTwoDecimalPlacesTest() {
        Assert.assertEquals("10.59", NumberFormatUtils.keepTwoDecimalPlaces("10.59254"))
        Assert.assertEquals("10.6", NumberFormatUtils.keepTwoDecimalPlaces("10.596"))
        Assert.assertEquals("0", NumberFormatUtils.keepTwoDecimalPlaces("10.596as"))
    }


    @Test
    fun customDecimalPlaces() {
        Assert.assertEquals("10.6", NumberFormatUtils.customDecimalPlaces("10.567", 1))
        Assert.assertEquals("10.4", NumberFormatUtils.customDecimalPlaces("10.447", 1))
    }
}