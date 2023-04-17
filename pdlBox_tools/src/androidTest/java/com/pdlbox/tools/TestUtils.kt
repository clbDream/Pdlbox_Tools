package com.pdlbox.tools

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pdlbox.tools.utils.EncodeUtils
import com.pdlbox.tools.utils.PhoneUtils
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestUtils {

    @Test
    fun base64Encode(){
        val encodeBase64 = EncodeUtils.encodeBase64("ssssssffdgfdgfd")
        assertEquals("c3Nzc3NzZmZkZ2ZkZ2Zk\n", encodeBase64)
    }

    @Test
    fun base64Decode(){
        val encodeBase64 = EncodeUtils.decodeBase64("c3Nzc3NzZmZkZ2ZkZ2Zk")
        assertEquals("ssssssffdgfdgfd", encodeBase64)
    }

    @Test
    fun testPhoneHide(){
        val string = PhoneUtils.phoneNumberHide("17600686054")
        assertEquals("176****6054", string)
    }
}