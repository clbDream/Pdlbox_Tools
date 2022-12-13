package com.pdlbox.tools.utils

import android.Manifest.permission
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.net.Uri
import android.net.wifi.WifiManager
import android.os.Build
import android.provider.Settings
import android.telephony.TelephonyManager
import android.text.TextUtils
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import com.pdlbox.tools.Utils.getApp
import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import java.util.*


/**
 * 设备相关
 */
object DeviceUtils {

    /**
     * 设备是否root.
     *
     */
    val isDeviceRooted: Boolean
        get() {
            val su: String = "su"
            val locations: Array<String> = arrayOf(
                "/system/bin/",
                "/system/xbin/",
                "/sbin/",
                "/system/sd/xbin/",
                "/system/bin/failsafe/",
                "/data/local/xbin/",
                "/data/local/bin/",
                "/data/local/",
                "/system/sbin/",
                "/usr/bin/",
                "/vendor/bin/"
            )
            for (location: String in locations) {
                if (File(location + su).exists()) {
                    return true
                }
            }
            return false
        }

    /**
     * 判断设备 ADB 是否可用
     *
     */
    @get:RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    val isAdbEnabled: Boolean
        get() = Settings.Secure.getInt(
            getApp().contentResolver,
            Settings.Global.ADB_ENABLED, 0
        ) > 0

    /**
     * 获取设备系统版本号
     *
     */
    val sDKVersionName: String
        get() {
            return Build.VERSION.RELEASE
        }

    /**
     * 获取设备系统版本码
     *
     */
    val sDKVersionCode: Int
        get() {
            return Build.VERSION.SDK_INT
        }

    /**
     * 获取设备 AndroidID
     *
     */
    @get:SuppressLint("HardwareIds")
    val androidID: String
        get() {
            val id: String? = Settings.Secure.getString(
                getApp().contentResolver,
                Settings.Secure.ANDROID_ID
            )
            if (("9774d56d682e549c" == id)) return ""
            return if (id == null) "" else id
        }

    /**
     * 判断wifi是否可用
     */
    @set:RequiresPermission(permission.CHANGE_WIFI_STATE)
    var wifiEnabled: Boolean
        get() {
            @SuppressLint("WifiManagerLeak") val manager: WifiManager =
                getApp().getSystemService(
                    Context.WIFI_SERVICE
                ) as WifiManager
            return manager.isWifiEnabled
        }
        private set(enabled) {
            @SuppressLint("WifiManagerLeak") val manager: WifiManager =
                getApp().getSystemService(
                    Context.WIFI_SERVICE
                ) as WifiManager
            if (enabled == manager.isWifiEnabled) return
            manager.isWifiEnabled = enabled
        }

    /**
     * 获取设备厂商
     */
    val manufacturer: String
        get() {
            return Build.MANUFACTURER
        }

    /**
     * 获取设备型号
     */
    val model: String
        get() {
            var model: String? = Build.MODEL
            if (model != null) {
                model = model.trim { it <= ' ' }.replace("\\s*".toRegex(), "")
            } else {
                model = ""
            }
            return model
        }

    /**
     * 获取设备支持的架构类型
     */
    val aBIs: Array<String>
        get() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                return Build.SUPPORTED_ABIS
            } else {
                if (!TextUtils.isEmpty(Build.CPU_ABI2)) {
                    return arrayOf(Build.CPU_ABI, Build.CPU_ABI2)
                }
                return arrayOf(Build.CPU_ABI)
            }
        }

    /**
     * 是否是平板
     */
    val isTablet: Boolean
        get() {
            return ((Resources.getSystem().configuration.screenLayout
                    and Configuration.SCREENLAYOUT_SIZE_MASK)
                    >= Configuration.SCREENLAYOUT_SIZE_LARGE)
        }//        boolean checkDebuggerConnected = Debug.isDebuggerConnected();
//        if (checkDebuggerConnected) return true;
    /**
     * 是否是模拟器
     */
    val isEmulator: Boolean
        get() {
            val checkProperty: Boolean = (Build.FINGERPRINT.startsWith("generic")
                    || Build.FINGERPRINT.lowercase(Locale.getDefault()).contains("vbox")
                    || Build.FINGERPRINT.lowercase(Locale.getDefault()).contains("test-keys")
                    || Build.MODEL.contains("google_sdk")
                    || Build.MODEL.contains("Emulator")
                    || Build.MODEL.contains("Android SDK built for x86")
                    || Build.MANUFACTURER.contains("Genymotion")
                    || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
                    || ("google_sdk" == Build.PRODUCT))
            if (checkProperty) return true
            var operatorName: String = ""
            val tm: TelephonyManager? =
                getApp().getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            if (tm != null) {
                val name: String? = tm.networkOperatorName
                if (name != null) {
                    operatorName = name
                }
            }
            val checkOperatorName: Boolean =
                (operatorName.lowercase(Locale.getDefault()) == "android")
            if (checkOperatorName) return true
            val url: String = "tel:" + "123456"
            val intent: Intent = Intent()
            intent.data = Uri.parse(url)
            intent.action = Intent.ACTION_DIAL
            val checkDial: Boolean = intent.resolveActivity(getApp().packageManager) == null
            if (checkDial) return true
            if (isEmulatorByCpu) return true

            //        boolean checkDebuggerConnected = Debug.isDebuggerConnected();
            //        if (checkDebuggerConnected) return true;
            return false
        }

    /**
     * Returns whether is emulator by check cpu info.
     * by function of [.readCpuInfo], obtain the device cpu information.
     * then compare whether it is intel or amd (because intel and amd are generally not mobile phone cpu), to determine whether it is a real mobile phone
     *
     * @return `true`: yes<br></br>`false`: no
     */
    private val isEmulatorByCpu: Boolean
        private get() {
            val cpuInfo: String = readCpuInfo()
            return cpuInfo.contains("intel") || cpuInfo.contains("amd")
        }

    /**
     * Return Cpu information
     *
     * @return Cpu info
     */
    private fun readCpuInfo(): String {
        var result: String = ""
        try {
            val args: Array<String> = arrayOf("/system/bin/cat", "/proc/cpuinfo")
            val cmd: ProcessBuilder = ProcessBuilder(*args)
            val process: Process = cmd.start()
            val sb: StringBuilder = StringBuilder()
            var readLine: String?
            val responseReader: BufferedReader =
                BufferedReader(InputStreamReader(process.inputStream, "utf-8"))
            while ((responseReader.readLine().also { readLine = it }) != null) {
                sb.append(readLine)
            }
            responseReader.close()
            result = sb.toString().lowercase(Locale.getDefault())
        } catch (ignored: IOException) {
        }
        return result
    }
}
