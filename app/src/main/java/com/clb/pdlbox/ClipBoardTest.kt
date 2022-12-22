package com.clb.pdlbox

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pdlbox.tools.utils.ClipboardUtils

class ClipBoardTest: AppCompatActivity() {

    private val input_view:EditText? by lazy { findViewById(R.id.input_view) }
    private val show_view: TextView? by lazy { findViewById(R.id.show_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clip_board)
    }

    fun copyText(view: View) {
        val toString = input_view?.text.toString()
        ClipboardUtils.copyText(toString)
    }

    fun geText(view: View) {
        val text = ClipboardUtils.getText()
        show_view?.text = text
    }

    fun clearClip(view: View) {
        ClipboardUtils.clear()
    }
}