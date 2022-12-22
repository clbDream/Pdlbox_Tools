package com.pdlbox.tools.utils

import net.sourceforge.pinyin4j.PinyinHelper
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination

object PinyinUtils {

    /**
     * 将字符串中的中文转化为拼音,其他字符不变
     * 花花大神->huahuadashen
     * @param inputString
     * @return
     */
    fun getPingYin(inputString: String): String {
        val format = HanyuPinyinOutputFormat()
        format.caseType = HanyuPinyinCaseType.LOWERCASE
        format.toneType = HanyuPinyinToneType.WITHOUT_TONE
        format.vCharType = HanyuPinyinVCharType.WITH_V
        val input = inputString.trim { it <= ' ' }.toCharArray()
        var output = ""
        try {
            for (curchar in input) {
                output += if (curchar.toString().matches(
                        Regex("[\\u4E00-\\u9FA5]+")
                    )
                ) {
                    val temp = PinyinHelper.toHanyuPinyinStringArray(
                        curchar, format
                    )
                    temp[0]
                } else Character.toString(curchar)
            }
        } catch (e: BadHanyuPinyinOutputFormatCombination) {
            e.printStackTrace()
        }
        return output
    }

    /**
     * 汉字转换为汉语拼音首字母，英文字符不变
     * 花花大神->hhds
     * @param chinese 汉字
     * @return 拼音
     */
    fun getFirstSpell(chinese: String): String {
        val pybf = StringBuffer()
        val arr = chinese.toCharArray()
        val defaultFormat = HanyuPinyinOutputFormat()
        defaultFormat.caseType = HanyuPinyinCaseType.LOWERCASE
        defaultFormat.toneType = HanyuPinyinToneType.WITHOUT_TONE
        for (curchar in arr) {
            if (curchar.code > 128) {
                try {
                    val temp = PinyinHelper.toHanyuPinyinStringArray(curchar, defaultFormat)
                    if (temp != null) {
                        pybf.append(temp[0][0])
                    }
                } catch (e: BadHanyuPinyinOutputFormatCombination) {
                    e.printStackTrace()
                }
            } else {
                pybf.append(curchar)
            }
        }
        return pybf.toString().replace("\\W".toRegex(), "").trim { it <= ' ' }
    }
}