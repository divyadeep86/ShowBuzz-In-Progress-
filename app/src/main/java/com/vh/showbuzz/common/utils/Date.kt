package com.vh.showbuzz.common.utils

import android.os.Build
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.Locale

fun String.extractYear(): Int {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val date = LocalDate.parse(this, formatter)
        date.year
    } else {
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = formatter.parse(this)
        val calendar = java.util.Calendar.getInstance()
        if (date != null) {
            calendar.time = date
        }
        calendar.get(java.util.Calendar.YEAR)
    }
}

fun String.toDate(): Date? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val date = LocalDate.parse(this, formatter)
        Date.from(date.atStartOfDay().atZone(java.time.ZoneId.systemDefault()).toInstant())
    } else {
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = formatter.parse(this)
        date
    }
}
fun getCurrentDate(): Date {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val date = LocalDate.now()
        Date.from(date.atStartOfDay().atZone(java.time.ZoneId.systemDefault()).toInstant())
    } else {
        val calendar = java.util.Calendar.getInstance()
        calendar.time = Date()
        calendar.time
    }
}
fun getCurrentDateString(format:String ="yyyy-MM-dd"): String {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val currentDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern(format)
        currentDate.format(formatter)
    } else {
        val currentDate = Date()
        val formatter = SimpleDateFormat(format, Locale.getDefault())
        formatter.format(currentDate)
    }
}
fun getCurrentDatePlusYearString(addYear:Int =0,format:String ="yyyy-MM-dd"): String {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val currentDate = LocalDate.now()
        val newDate = currentDate.plusYears(addYear.toLong())
        val formatter = DateTimeFormatter.ofPattern(format)
        newDate.format(formatter)
    } else {
        val calendar = Calendar.getInstance()
        calendar.time = Date()
        calendar.add(Calendar.YEAR, addYear)
        val formatter = SimpleDateFormat(format, Locale.getDefault())
        formatter.format(calendar.time)
    }
}