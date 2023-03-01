package com.example.zhongchou3

import android.text.InputFilter
import android.text.Spanned


class DecimalDigitsInputFilter(
    private val digitsBeforeZero: Int,
    private val digitsAfterZero: Int
) :
    InputFilter {
    override fun filter(
        source: CharSequence,
        start: Int,
        end: Int,
        dest: Spanned,
        dstart: Int,
        dend: Int
    ): CharSequence? {
        val sb = StringBuilder(dest)
        sb.insert(dstart, source)
        val digitsIndex = sb.indexOf(".")
        if (digitsIndex != sb.lastIndexOf(".")) {
            return ""
        }
        if (digitsIndex < 0) {
            return if (sb.length > digitsBeforeZero) "" else null
        }
        if (digitsIndex == 0) {
            return ""
        }
        if (digitsIndex > digitsBeforeZero) {
            return ""
        }
        return if (sb.length - digitsIndex - 1 > digitsAfterZero) {
            ""
        } else null
    }
}