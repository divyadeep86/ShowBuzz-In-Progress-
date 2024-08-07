package com.vh.showbuzz.common.utils

import kotlin.math.pow

fun Double.toPercentage(): Int {
    return if (this == 0.0) {
        0
    } else {
        (this * 10).toInt()
    }
}
fun Double.convertNumberToDouble(): Double {
   return this/10
}
