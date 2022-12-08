package com.clb.pdlbox

import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pdlbox.tools.utils.TimeUtils

/**
 * 时间工具测试类
 */
class TimeTest : AppCompatActivity() {
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var textView4: TextView
    private lateinit var textView5: TextView
    private lateinit var textView6: TextView
    private lateinit var textView7: TextView
    private lateinit var textView8: TextView
    private lateinit var textView9: TextView
    private lateinit var textView10: TextView
    private lateinit var textView11: TextView
    private lateinit var textView12: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_time)

        initView()
    }

    private fun initView() {
        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)
        textView4 = findViewById(R.id.textView4)
        textView5 = findViewById(R.id.textView5)
        textView6 = findViewById(R.id.textView6)
        textView7 = findViewById(R.id.textView7)
        textView8 = findViewById(R.id.textView8)
        textView9 = findViewById(R.id.textView9)
        textView10 = findViewById(R.id.textView10)
        textView11 = findViewById(R.id.textView11)
        textView12 = findViewById(R.id.textView12)
        textView2.text = "\"2020/12/22 12:24:32\" -> ${
            TimeUtils.string2millis("2020/12/22 12:24:32",
                TimeUtils.DATE_TYPE_2)
        }"

        textView10.text = TimeUtils.longFormatTime(System.currentTimeMillis() - 1000 * 5)
        textView11.text = TimeUtils.longFormatTime(System.currentTimeMillis() - 1000 * 60 * 2)
        textView12.text =
            TimeUtils.longFormatTime(System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 30)
        mHandler.postDelayed(mRunnable, 1000L)
    }

    private val mHandler = Handler()
    private val mRunnable = object : Runnable {
        override fun run() {
            runOnUiThread {
                textView1.text =
                    TimeUtils.millis2String(System.currentTimeMillis(), TimeUtils.DATE_TYPE_1)
                textView3.text =
                    TimeUtils.millis2String(System.currentTimeMillis(), TimeUtils.DATE_TYPE_2)
                textView4.text =
                    TimeUtils.millis2String(System.currentTimeMillis(), TimeUtils.DATE_TYPE_3)
                textView5.text =
                    TimeUtils.millis2String(System.currentTimeMillis(), TimeUtils.DATE_TYPE_4)
                textView6.text =
                    TimeUtils.millis2String(System.currentTimeMillis(), TimeUtils.DATE_TYPE_5)
                textView7.text =
                    TimeUtils.millis2String(System.currentTimeMillis(), TimeUtils.DATE_TYPE_6)
                textView8.text =
                    TimeUtils.millis2String(System.currentTimeMillis(), TimeUtils.DATE_TYPE_7)
                textView9.text =
                    TimeUtils.millis2String(System.currentTimeMillis(), TimeUtils.DATE_TYPE_8)
            }
            mHandler.postDelayed(this, 1000L)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        mHandler.removeCallbacks(mRunnable)
    }
}