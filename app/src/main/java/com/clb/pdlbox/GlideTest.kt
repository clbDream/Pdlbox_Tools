package com.clb.pdlbox

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.pdlbox.tools.utils.GlideUtils

class GlideTest: AppCompatActivity() {

    private val iv1:ImageView? by lazy { findViewById(R.id.iv1) }
    private val iv2:ImageView? by lazy { findViewById(R.id.iv2) }
    private val iv3:ImageView? by lazy { findViewById(R.id.iv3) }
    private val iv4:ImageView? by lazy { findViewById(R.id.iv4) }
    private val iv5:ImageView? by lazy { findViewById(R.id.iv5) }

    private val testImg = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Flmg.jj20.com%2Fup%2Fallimg%2F1114%2F042421133312%2F210424133312-1-1200.jpg&refer=http%3A%2F%2Flmg.jj20.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1674645748&t=faa84a0a07de6d2314be2f66a81a95be"
    private val gifImg = "https://image.niwoxuexi.com/blog/content/5c0d4b1972-loading.gif"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide_test)

        iv1?.let { GlideUtils.showImg(testImg, it) }
        iv2?.let { GlideUtils.showRoundCornerImg(testImg, it,10f,
            leftTop = true,
            rightTop = true,
            leftBottom = true,
            rightBottom = true
        ) }
        iv5?.let { GlideUtils.showRoundCornerImg(testImg, it,30f, leftBottom = true, rightTop = true) }
        iv3?.let { GlideUtils.showRoundImg(testImg, it) }
        iv4?.let { GlideUtils.showGigImg(gifImg, it) }
    }
}