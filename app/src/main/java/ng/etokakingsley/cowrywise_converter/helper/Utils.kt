package ng.etokakingsley.cowrywise_converter.helper

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Utility class with different methods
 */
object Utils {

    /**
     * @param givenDateString is the date to be converted to mill seconds i.e 2020-120-04
     * @param format is the format i.e yyyy-MM-dd
     */
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