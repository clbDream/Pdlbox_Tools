package com.clb.pdlbox

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pdlbox.tools.utils.StringUtils

/**
 * @ClassName: StringTest
 * @Description:
 * @Author: 常利兵
 * @Date: 2023/4/25 17:17
 **/
class StringTest : AppCompatActivity() {

    private val tv_1: TextView? by lazy { findViewById(R.id.tv_1) }
    private val tv_2: TextView? by lazy { findViewById(R.id.tv_2) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_string_test)
    }

    fun randomStr(view: View) {
        tv_1?.text = StringUtils.generateRandomStrNumberAndLetter(10)
    }

    fun randomStrChinese(view: View) {
        tv_2?.text = StringUtils.generateRandomStrChinese(10)
    }
}