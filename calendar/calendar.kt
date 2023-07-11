class Calendar(val year: Int) {
    val daySpacing = 1
    val columnSpacing = 3
    val dayWidth = 3
    val daySeparator = "".padEnd(daySpacing)
    val emptyDay = "".padEnd(dayWidth)
    val columnSeparator = "".padEnd(columnSpacing)
    val columnWidth = 7 * dayWidth + 6 * daySpacing

    val weekDayHeader =
            listOf("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")
            .map{ it.padStart(dayWidth) }
            .joinToString(daySeparator)

    val monthNames =
            listOf(
                "JANUNARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE",
                "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"
            ).map{ it.center(columnWidth) }

    val firstDays = IntArray(12){ m -> firstDayOfMonth(year, m + 1) }
    val lastDays = IntArray(12){ m -> getDays(year, m + 1) }

    private fun printMonths(startMonth: Int, columnCount: Int) {
        var m = startMonth - 1
        print(monthNames[m++])
        for (i in 1 until columnCount) {
            print(columnSeparator)
            print(monthNames[m++])
        }
        print("\n")
    }

    private fun printWeekDays(columnCount: Int) {
        print(weekDayHeader)
        for (i in 1 until columnCount) {
            print(columnSeparator)
            print(weekDayHeader)
        }
        print("\n")
    }

    private fun printDay(d: Int) = print(d.toString().padStart(dayWidth))

    private fun printLine(firstMonth: Int, days: IntArray): Boolean {
        var finishedCount = 0
        var month = firstMonth - 1

        for (i in 0 until days.size) {
            for (d in 0..6) {
                if (days[i] == 0) {
                    if (d < firstDays[month]) {
                        print(emptyDay)
                    } else {
                        printDay(++days[i])
                    }
                } else {
                    ++days[i]
                    if (days[i] <= lastDays[month]) {
                        printDay(days[i])
                    } else {
                        print(emptyDay)
                    }
                }

                if (d < 6) print(daySeparator)
            }

            if (i < days.size - 1) print(columnSeparator)

            if (days[i] >= lastDays[month]) ++finishedCount

            ++month
        }
        print("\n")

        return finishedCount < days.size
    }

    fun print(columnCount: Int) {
        var startMonth = 1
        var days = IntArray(columnCount)

        while (startMonth <= 12) {
            days.fill(0)

            printMonths(startMonth, columnCount)
            printWeekDays(columnCount)
            while (printLine(startMonth, days)) {
            }
            print("\n")

            startMonth += columnCount
        }
    }
}
