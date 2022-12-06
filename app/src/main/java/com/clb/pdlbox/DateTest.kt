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
    private lateinit var textView2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_date)

        initView()
    }

    private fun initView() {
        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)

        textView1.text = DateUtils.millis2String(System.currentTimeMillis(), "yyyy/MM/dd")
        textView2.text = DateUtils.string2millis("2020/12/22").toString()
    }
}