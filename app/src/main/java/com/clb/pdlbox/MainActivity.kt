package com.clb.pdlbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun dateTest(view: View) {
        startActivity(Intent(this,DateTest::class.java))
    }

    fun timeTest(view: View) {
        startActivity(Intent(this,TimeTest::class.java))
    }

    fun conversionTest(view: View) {
        startActivity(Intent(this,ConversionTest::class.java))
    }

    fun toastTest(view: View) {
        startActivity(Intent(this,ToastTest::class.java))
    }

    fun spTest(view: View) {
        startActivity(Intent(this,SpTest::class.java))
    }
}