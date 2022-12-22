package com.pdlbox.tools

import com.pdlbox.tools.utils.PinyinUtils
import org.junit.Assert
import org.junit.Test

class PinyinTest {

    @Test
    fun getPinyin(){
        Assert.assertEquals("huahuadashen",PinyinUtils.getPingYin("花花大神"))
        Assert.assertEquals("hhds",PinyinUtils.getFirstSpell("花花大神"))
    }
}