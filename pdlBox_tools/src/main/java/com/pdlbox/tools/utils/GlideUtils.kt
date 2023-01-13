package com.pdlbox.tools.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pdlbox.tools.Utils
import com.pdlbox.tools.glide.CornerTransform

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
        Glide.get(Utils.getApp()).clearDiskCache()
    }

    /**
     * *****************************
     * 加载正常的图片
     *
     */
    fun showImg(url: Any, view: ImageView) {
        Glide.with(Utils.getApp())
            .load(url)
            .into(view)
    }

    /**
     * *****************************
     * 加载圆角图片
     *
     */
    fun showRoundCornerImg(
        url: Any,
        view: ImageView,
        radius: Float = 0f
    ) {
        showRoundCornerImg(
            url, view, radius,
            leftTop = true,
            rightTop = true,
            leftBottom = true,
            rightBottom = true
        )
    }

    /**
     * *****************************
     * 加载圆角图片
     *
     */
    fun showRoundCornerImg(
        url: Any,
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

        Glide.with(Utils.getApp())
            .load(url)
            .apply(options)
            .into(view)
    }


    /**
     * *****************************
     * 加载圆形图片
     *
     */
    fun showRoundImg(url: Any, view: ImageView) {
        Glide.with(Utils.getApp())
            .load(url)
            .apply(RequestOptions.circleCropTransform())
            .into(view)
    }

    /**
     * *****************************
     * 加载gif图片
     *
     */
    fun showGigImg(url: Any, view: ImageView) {
        Glide.with(Utils.getApp())
            .load(url)
            .into(view)
    }

}