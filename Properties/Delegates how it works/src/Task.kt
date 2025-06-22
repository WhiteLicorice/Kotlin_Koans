import java.util.Calendar
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class D {
    var date: MyDate by EffectiveDate()
}

class EffectiveDate<R> : ReadWriteProperty<R, MyDate> {

    var timeInMillis: Long? = null

    override fun getValue(thisRef: R, property: KProperty<*>): MyDate {
        // Default to the current MyDate if get is called before set
        if (timeInMillis != null) {
            return timeInMillis!!.toDate()
        }

        val now = Calendar.getInstance()
        val currentDate = MyDate(
            year = now.get(Calendar.YEAR),
            month = now.get(Calendar.MONTH),
            dayOfMonth = now.get(Calendar.DAY_OF_MONTH)
        )

        return currentDate
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: MyDate) {
        timeInMillis = value.toMillis()
    }
}

