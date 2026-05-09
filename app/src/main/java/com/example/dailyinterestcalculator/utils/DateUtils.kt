package com.example.dailyinterestcalculator.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateUtils {
    private val formatter = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    fun formatDate(time: Long): String {
        return formatter.format(Date(time))
    }
}