package com.clb.pdlbox

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pdlbox.tools.DateUtils

/**
 * 日期工具测试类
 */
class DateTest : AppCompatActivity() {

    private lateinit var textView1: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_date)

        initView()
    }

    private fun initView() {
        textView1 = findViewById(R.id.textView1)

        textView1.text = DateUtils.formatDateToString(System.currentTimeMillis(), "yyyy/MM/dd")
    }
}