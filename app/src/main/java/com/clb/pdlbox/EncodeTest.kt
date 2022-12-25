package com.clb.pdlbox

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.pdlbox.tools.utils.EncodeUtils

class EncodeTest: AppCompatActivity() {

    private val inputView1:EditText? by lazy { findViewById(R.id.input_view1) }
    private val inputView2 :EditText? by lazy { findViewById(R.id.input_view2) }

    private var str1 = ""
    private var str2 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encode)

        inputView1?.addTextChangedListener {
            str1 = it.toString()
        }

        inputView2?.addTextChangedListener {
            str2 = it.toString()
        }
    }

    fun bianma(view: View) {
        inputView2?.setText(EncodeUtils.encodeBase64(str1))
    }
    fun jiema(view: View) {
        inputView1?.setText(EncodeUtils.decodeBase64(str2))
    }
}