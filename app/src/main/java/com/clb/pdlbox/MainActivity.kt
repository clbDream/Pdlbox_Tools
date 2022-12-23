package com.clb.pdlbox

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.pdlbox.tools.utils.GsonUtils
import com.pdlbox.tools.utils.LogUtils
import com.pdlbox.tools.utils.ScreenUtils
import com.pdlbox.tools.utils.ToastUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun dateTest(view: View) {
        startActivity(Intent(this, DateTest::class.java))
    }

    fun timeTest(view: View) {
        startActivity(Intent(this, TimeTest::class.java))
    }

    fun conversionTest(view: View) {
        startActivity(Intent(this, ConversionTest::class.java))
    }

    fun toastTest(view: View) {
        startActivity(Intent(this, ToastTest::class.java))
    }

    fun spTest(view: View) {
        startActivity(Intent(this, SpTest::class.java))
    }

    fun deviceTest(view: View) {
        startActivity(Intent(this, DeviceTest::class.java))
    }

    fun clipBoardTest(view: View) {
        startActivity(Intent(this, ClipBoardTest::class.java))
    }

}