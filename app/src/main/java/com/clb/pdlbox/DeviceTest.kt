package com.clb.pdlbox

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.pdlbox.tools.utils.DeviceUtils

/**
 * 测试设备相关
 */
class DeviceTest: AppCompatActivity() {

    private val tv_1:TextView? by lazy { findViewById(R.id.tv_1) }
    private val tv_2:TextView? by lazy { findViewById(R.id.tv_2) }
    private val tv_3:TextView? by lazy { findViewById(R.id.tv_3) }
    private val tv_4:TextView? by lazy { findViewById(R.id.tv_4) }
    private val tv_5:TextView? by lazy { findViewById(R.id.tv_5) }
    private val tv_6:TextView? by lazy { findViewById(R.id.tv_6) }
    private val tv_7:TextView? by lazy { findViewById(R.id.tv_7) }
    private val tv_8:TextView? by lazy { findViewById(R.id.tv_8) }
    private val tv_9:TextView? by lazy { findViewById(R.id.tv_9) }
    private val tv_10:TextView? by lazy { findViewById(R.id.tv_10) }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_device_test)

        tv_1?.text = DeviceUtils.isDeviceRooted.toString()
        tv_2?.text = DeviceUtils.isAdbEnabled.toString()
        tv_3?.text = DeviceUtils.sDKVersionName.toString()
        tv_4?.text = DeviceUtils.sDKVersionCode.toString()
        tv_5?.text = DeviceUtils.androidID.toString()
        tv_6?.text = DeviceUtils.manufacturer.toString()
        tv_7?.text = DeviceUtils.model.toString()
        tv_9?.text = DeviceUtils.isTablet.toString()
        tv_10?.text = DeviceUtils.isEmulator.toString()
        val tempList = ArrayList<String>()
        DeviceUtils.aBIs.forEach {
            tempList.add(it)
        }
        tv_8?.text = tempList.toString()

    }
}