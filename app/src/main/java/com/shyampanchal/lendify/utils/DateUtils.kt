package com.shyampanchal.lendify.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    fun convertUnixToDate(unixTimestamp: Long) = Date(unixTimestamp)

    fun getFormattedDateText(date: Date): String {
        val sdf = SimpleDateFormat("MMM dd, yyyy", Locale.CANADA)
        return sdf.format(date)
    }
}