import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

enum class TimeInterval { DAY, WEEK, YEAR }

// Support adding a single TimeInterval
operator fun MyDate.plus(interval: TimeInterval): MyDate {
    val defaultIncrement = 1
    return addTimeIntervals(interval, defaultIncrement)
}

// Support adding repeated intervals (like YEAR * 2)
data class RepeatedTimeInterval(val timeInterval: TimeInterval, val multiplier: Int)

operator fun TimeInterval.times(times: Int): RepeatedTimeInterval {
    return RepeatedTimeInterval(this, times)
}

operator fun MyDate.plus(repeat: RepeatedTimeInterval): MyDate {
    return addTimeIntervals(repeat.timeInterval, repeat.multiplier)
}

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
