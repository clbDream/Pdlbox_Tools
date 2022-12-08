package com.pdlbox.tools

import com.pdlbox.tools.utils.DistanceUtils
import org.junit.Assert
import org.junit.Test

class DistanceTest {

    @Test
    fun mToDecimeter() {
        Assert.assertEquals(10, DistanceUtils.mToDecimeter(1))
        Assert.assertEquals(100, DistanceUtils.decimeterToCm(10))
    }
}