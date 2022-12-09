package com.clb.pdlbox

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.pdlbox.tools.utils.SpUtils

class SpTest: AppCompatActivity() {

    private val et_1:EditText? by lazy { findViewById(R.id.et_1)}
    private val et_2:EditText? by lazy { findViewById(R.id.et_2)}
    private val et_3:EditText? by lazy { findViewById(R.id.et_3)}
    private val et_4:EditText? by lazy { findViewById(R.id.et_4)}
    private val et_5:EditText? by lazy { findViewById(R.id.et_5)}
    private val et_6:EditText? by lazy { findViewById(R.id.et_6)}
    private val et_7:EditText? by lazy { findViewById(R.id.et_7)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_sp)
    }

    fun getValue(view: View) {
        val filename = et_4?.text?.toString().toString()
        val keyname = et_5?.text?.toString().toString()
        val keyValue = SpUtils.getString(filename,keyname)
        et_6?.setText(keyValue)
    }
    fun saveValue(view: View) {
        val filename = et_1?.text?.toString().toString()
        val keyname = et_2?.text?.toString().toString()
        val keyValue = et_3?.text?.toString().toString()
        SpUtils.put(filename,keyname,keyValue)
    }

    fun clean(view: View) {
        val filename = et_7?.text?.toString().toString()
        SpUtils.clear(filename)
    }
}