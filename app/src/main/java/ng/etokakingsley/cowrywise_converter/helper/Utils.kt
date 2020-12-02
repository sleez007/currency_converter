package ng.etokakingsley.cowrywise_converter.helper

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object Utils {
    fun getDateInMilliSeconds(givenDateString: String?, format: String): Long {
        val sdf = SimpleDateFormat(format, Locale.getDefault())
        var timeInMilliseconds: Long = 1
        try {
            val mDate: Date = sdf.parse(givenDateString)
            timeInMilliseconds = mDate.time
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return timeInMilliseconds
    }
}