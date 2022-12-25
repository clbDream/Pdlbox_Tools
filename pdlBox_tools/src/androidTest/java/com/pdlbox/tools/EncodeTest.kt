package com.pdlbox.tools

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pdlbox.tools.utils.EncodeUtils
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EncodeTest {

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
}