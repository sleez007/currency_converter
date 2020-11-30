package ng.etokakingsley.cowrywise_converter.db.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ng.etokakingsley.cowrywise_converter.db.entities.Rate

@Dao
interface RateDao {
    @Query("SELECT * FROM rate_table WHERE base=:base AND toCurrency=:currency ORDER BY id DESC LIMIT 1")
    fun fetchRate(base: String, currency: String) : Flow<Rate>

    @Query("SELECT * FROM rate_table")
    fun fetchAll() : Flow<List<Rate>>
}