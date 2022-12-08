package com.clb.pdlbox

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pdlbox.tools.utils.ConversionUtils

class ConversionTest: AppCompatActivity() {

    private val et_1:EditText? by lazy { findViewById(R.id.et_1) }
    private val tv_1:TextView? by lazy { findViewById(R.id.tv_1) }

    private val et_2:EditText? by lazy { findViewById(R.id.et_2) }
    private val tv_2:TextView? by lazy { findViewById(R.id.tv_2) }

    private val et_3:EditText? by lazy { findViewById(R.id.et_3) }
    private val tv_3:TextView? by lazy { findViewById(R.id.tv_3) }

    private val et_4:EditText? by lazy { findViewById(R.id.et_4) }
    private val tv_4:TextView? by lazy { findViewById(R.id.tv_4) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_conversion)

    }

    fun dp2px(view: View) {
        tv_1?.text = et_1?.text?.toString()?.toFloat()?.let { ConversionUtils.dp2Px(it).toString() }
    }

    fun px2dp(view: View) {
        tv_2?.text = et_2?.text?.toString()?.toFloat()?.let { ConversionUtils.px2dp(it).toString() }
    }

    fun sp2px(view: View) {
        tv_3?.text = et_3?.text?.toString()?.toFloat()?.let { ConversionUtils.sp2px(it).toString() }
    }

    fun px2sp(view: View) {
        tv_4?.text = et_4?.text?.toString()?.toFloat()?.let { ConversionUtils.px2sp(it).toString() }
    }
}