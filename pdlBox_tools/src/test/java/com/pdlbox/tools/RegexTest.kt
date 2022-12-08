package com.pdlbox.tools

import com.pdlbox.tools.utils.RegexUtils
import org.junit.Test
import org.junit.Assert.*

class RegexTest {

    @Test
    fun isPhoneNumber(){
        assertTrue(RegexUtils.isPhoneNumberSimple("17600686054"))
        assertTrue(RegexUtils.isPhoneNumberSimple("17600686050"))
        assertTrue(RegexUtils.isPhoneNumberStrict("17600686054"))
        assertTrue(RegexUtils.isPhoneNumberStrict("17654000000"))

        assertEquals(true,RegexUtils.isPhoneNumberSimple("17600686054"))
        assertEquals(false,RegexUtils.isPhoneNumberSimple("1760068605"))
        assertEquals(false,RegexUtils.isPhoneNumberStrict("176006860562"))
        assertEquals(true,RegexUtils.isPhoneNumberStrict("17600686054"))
    }

    @Test
    fun isLegalName(){
        assertEquals(true,RegexUtils.isLegalName("张三"))
        assertEquals(false,RegexUtils.isLegalName("151"))
        assertEquals(false,RegexUtils.isLegalName("Albert Einstein"))
        assertEquals(false,RegexUtils.isLegalName("Mac.clb"))
    }

    /**
     * 验证是否是身份证号
     */
    @Test
    fun isLegalId() {
        assertEquals(false,RegexUtils.isLegalId("411022222222"))
        assertEquals(true,RegexUtils.isLegalId("111111111111111111"))
        assertEquals(false,RegexUtils.isLegalId("4115550201659919041"))
    }

    @Test
    fun isEmail() {
        assertEquals(true,RegexUtils.isEmail("3211114986@qq.com"))
        assertEquals(false,RegexUtils.isEmail("3211114986@12com"))
    }

    @Test
    fun matchChinese() {
        assertEquals(true,RegexUtils.matchChinese("张三的手机端你放假"))
        assertEquals(false,RegexUtils.matchChinese("张三的手机端你放假123"))
        assertEquals(false,RegexUtils.matchChinese("3211114986@12com"))
    }

    @Test
    fun isTime() {
        assertEquals(true,RegexUtils.isTime("21:32:25"))
        assertEquals(false,RegexUtils.isTime("张三的手机端你放假123"))
        assertEquals(false,RegexUtils.isTime("3211114986@12com"))
    }

    @Test
    fun isDate() {
        assertEquals(true,RegexUtils.isDate("2022-12-24"))
        assertEquals(false,RegexUtils.isDate("张三的手机端你放假123"))
        assertEquals(false,RegexUtils.isDate("3211114986@12com"))
    }

    @Test
    fun isCarNumber() {
        assertEquals(true,RegexUtils.isCarNumber("豫DD2531"))
        assertEquals(false,RegexUtils.isCarNumber("豫655M11"))
        assertEquals(false,RegexUtils.isCarNumber("321111498"))
    }
}