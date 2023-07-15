package com.pdlbox.tools.utils

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * @ClassName: HtmlUtils
 * @Description: 网页工具累
 * @Author: 常利兵
 * @Date: 2023/7/15 15:08
 **/
object HtmlUtils {

    /**
     * 解析富文本里面的图片工具类
     *
     * 需要将一段富文本字符串里面的图片提取出来上传到自己的服务器,更换原来的地址.
     */
    fun getImgStr(htmlStr: String?): List<String>? {
        val list: MutableList<String> = ArrayList()
        var img = ""
        val p_image: Pattern
        val m_image: Matcher
        // String regEx_img = "<img.*src=(.*?)[^>]*?>"; //图片链接地址
        val regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>"
        p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE)
        m_image = p_image.matcher(htmlStr)
        while (m_image.find()) {
            // 得到<img />数据
            img = m_image.group()
            // 匹配<img>中的src数据
            val m: Matcher = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img)
            while (m.find()) {
                list.add(m.group(1))
            }
        }
        //返回图片地址集合
        return list
    }


    /**
     * 解析富文本里面的图片工具类
     *  将富文本里面的图片地址排除掉
     */
    fun getImgStr2(htmlStr: String?): List<String>? {
        val list: MutableList<String> = ArrayList()
        val img = ""
        val p_image: Pattern
        val m_image: Matcher
        // String regEx_img = "<img.*src=(.*?)[^>]*?>"; //图片链接地址
        val regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>"
        p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE)
        m_image = p_image.matcher(htmlStr)
        while (m_image.find()) {
            // 得到<img />数据
            list.add(m_image.group())
        }
        return list
    }

    /**
     * 富文本提取纯文本
     * @param inputStr
     * @return
     */
    fun richTextExtractsPlainText(inputStr: String?): String {
        return if (inputStr == null || "" == inputStr.trim { it <= ' ' }) {
            ""
        } else inputStr.replace("\\&[a-zA-Z]{1,10};".toRegex(), "")
            .replace("<[a-zA-Z]+[1-9]?[^><]*>".toRegex(), "")
            .replace("</[a-zA-Z]+[1-9]?>".toRegex(), "")
            .replace("\\s*|\t|\r|\n".toRegex(), "")
    }
}