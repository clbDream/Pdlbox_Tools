package com.pdlbox.tools.utils

import android.os.Environment

import android.os.StatFs

import java.io.File


/**
 * SD卡相关的辅助类
 *
 */
object SDCardUtils {
    /**
     * 判断SDCard是否可用
     *
     * @return
     */
    var isSDCardEnable = (Environment.getExternalStorageState() ==
            Environment.MEDIA_MOUNTED)

    /**
     * 获取SD卡路径
     *
     * @return
     */
    val sDCardPath: String = (Environment.getExternalStorageDirectory().absolutePath
            + File.separator)

    // 获取空闲的数据块的数量
    // 获取单个数据块的大小（byte）
    /**
     * 获取SD卡的剩余容量 单位byte
     *
     * @return
     */
    val sDCardAllSize: Long
        get() {
            if (isSDCardEnable) {
                val stat: StatFs = StatFs(sDCardPath)
                // 获取空闲的数据块的数量
                val availableBlocks: Long = stat.availableBlocks.toLong() - 4
                // 获取单个数据块的大小（byte）
                val freeBlocks: Long = stat.availableBlocks.toLong()
                return freeBlocks * availableBlocks
            }
            return 0
        }

    /**
     * 获取指定路径所在空间的剩余可用容量字节数，单位byte
     *
     * @param filePath
     * @return 容量字节 SDCard可用空间，内部存储可用空间
     */
    fun getFreeBytes(filePath: String): Long {
        // 如果是sd卡的下的路径，则获取sd卡可用容量
        var filePath: String = filePath
        if (filePath.startsWith(sDCardPath)) {
            filePath = sDCardPath
        } else { // 如果是内部存储的路径，则获取内存存储的可用容量
            filePath = Environment.getDataDirectory().absolutePath
        }
        val stat: StatFs = StatFs(filePath)
        val availableBlocks: Long = stat.availableBlocks.toLong() - 4
        return stat.blockSize * availableBlocks
    }

    /**
     * 获取系统存储路径
     *
     * @return
     */
    val rootDirectoryPath: String
        get() {
            return Environment.getRootDirectory().absolutePath
        }
}  