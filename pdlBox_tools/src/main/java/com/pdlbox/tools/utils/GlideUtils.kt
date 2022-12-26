package com.pdlbox.tools.utils

import android.widget.ImageView
import com.bumptech.glide.request.RequestOptions
import com.pdlbox.tools.Utils
import com.pdlbox.tools.glide.CornerTransform
import com.pdlbox.tools.glide.GlideApp

/**
 * Glide图片加载
 */
object GlideUtils {

    /**
     * *****************************
     * 清除磁盘缓存
     *
     */
    fun clearDiskCache() {
        // 必须在后台线程中调用，建议同时clearMemory()
        GlideApp.get(Utils.getApp()).clearDiskCache()
    }

    /**
     * *****************************
     * 加载正常的图片
     *
     */
    fun showImg(url: String, view: ImageView) {
        GlideApp.with(Utils.getApp())
            .load(url)
            .into(view)
    }

    /**
     * *****************************
     * 加载圆角图片
     *
     */
    fun showRoundCornerImg(
        url: String,
        view: ImageView,
        radius: Float = 0f,
        leftTop: Boolean = false,
        rightTop: Boolean = false,
        leftBottom: Boolean = false,
        rightBottom: Boolean = false
    ) {
        // 加载为四个都是圆角的图片 可以设置圆角幅度
        val cornerTransform = CornerTransform(Utils.getApp(), radius)
        cornerTransform.setNeedCorner(leftTop, rightTop, leftBottom, rightBottom)
        val options = RequestOptions
            .bitmapTransform(cornerTransform)

        GlideApp.with(Utils.getApp())
            .load(url)
            .apply(options)
            .into(view)
    }


    /**
     * *****************************
     * 加载圆形图片
     *
     */
    fun showRoundImg(url: String, view: ImageView) {
        GlideApp.with(Utils.getApp())
            .load(url)
            .apply(RequestOptions.circleCropTransform())
            .into(view)
    }

    /**
     * *****************************
     * 加载gif图片
     *
     */
    fun showGigImg(url: String, view: ImageView) {
        GlideApp.with(Utils.getApp())
            .load(url)
            .into(view)
    }

}