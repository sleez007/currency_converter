package ng.etokakingsley.cowrywise_converter

import ng.etokakingsley.cowrywise_converter.helper.Utils
import org.junit.Assert
import org.junit.Test

class UtilClassTest {
    @Test
    fun isValidReturnType(){
        Assert.assertEquals(1606950000000, Utils.getDateInMilliSeconds("2020-12-03","yyyy-MM-dd"))
    }
}