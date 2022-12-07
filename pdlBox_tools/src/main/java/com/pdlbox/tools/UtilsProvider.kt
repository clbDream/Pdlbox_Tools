package com.pdlbox.tools

import android.app.Application
import androidx.core.content.FileProvider
import com.pdlbox.tools.Utils.init


/**
 * 提供工具类的初始化操作
 */
class UtilsProvider: FileProvider() {

    override fun onCreate(): Boolean {
        init(context?.applicationContext as Application)
        return true
    }
}