package com.clb.pdlbox

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.pdlbox.tools.utils.ToastUtils

class ToastTest: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_toast)
    }

    fun showShortToast(view: View) {
        ToastUtils.showShort("短期显示Toast")
    }

    fun showLongToast(view: View) {
        ToastUtils.showLong("长期显示Toast")
    }
//    fun showToast5s(view: View) {
//        ToastUtils.show("指定5秒显示Toast",5*1000)
//    }
}