package com.pdlbox.tools.utils

/**
 * 表情工具类
 */
object EmojiUtils {

    /**
     *
     * 检测是否有emoji表情
     */
    fun containsEmoji(source: String): Boolean {
        val len = source.length
        for (i in 0 until len) {
            val codePoint = source[i]
            if (!isEmojiCharacter(codePoint)) {
                return true
            }
        }
        return false
    }

    /**
     *
     * 判断是否是Emoji
     */
    private fun isEmojiCharacter(codePoint: Char): Boolean {
        return codePoint.code == 0x0 || codePoint.code == 0x9 || codePoint.code == 0xA ||
                codePoint.code == 0xD || codePoint.code in 0x20..0xD7FF ||
                codePoint.code in 0xE000..0xFFFD || (codePoint.code in 0x10000..0x10FFFF)
    }
}