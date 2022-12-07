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
}