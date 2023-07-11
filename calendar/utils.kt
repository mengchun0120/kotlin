fun isLeapYear(year: Int) =
    year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)

fun firstDayOfYear(year: Int): Int {
    val y = year - 1
    return (1 + y + (y / 4) - (y / 100) + (y / 400)) % 7
}

fun getDays(year: Int, month: Int) =
    when (month) {
        1, 3, 5, 7, 8, 10, 12 -> 31
        4, 6, 9, 11 -> 30
        2 -> if ( isLeapYear(year) ) 29 else 28
        else -> throw Exception("Invalid month {month}")
    }

fun firstDayOfMonth(year: Int, month: Int): Int {
    var day = firstDayOfYear(year)
    for (m in 1 until month) {
        day = (day + getDays(year, m)) % 7
    }
    return day
}

fun String.center(width: Int): String {
    if (this.length >= width) {
        return this
    } else {
        val left = width - this.length
        return "".padEnd(left / 2) + this + "".padEnd(left - left / 2)
    }
}
