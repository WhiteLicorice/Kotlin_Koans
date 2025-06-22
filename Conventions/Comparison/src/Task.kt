data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        if (this.year != other.year) {
            return this.year - other.year
        }
        if (this.month != other.month) {
            return this.month - other.month
        }
        if (this.dayOfMonth != other.dayOfMonth) {
            return this.dayOfMonth - other.dayOfMonth
        }
        return 0
    }
}

fun test(date1: MyDate, date2: MyDate) {
    // this code should compile:
    println(date1 < date2)
}
