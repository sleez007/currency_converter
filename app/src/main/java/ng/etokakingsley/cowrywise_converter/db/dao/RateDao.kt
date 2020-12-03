package ng.etokakingsley.cowrywise_converter.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ng.etokakingsley.cowrywise_converter.db.entities.Rate

@Dao
interface RateDao {
    @Query("SELECT * FROM rate_table WHERE toCurrency=:symbol ORDER BY date DESC LIMIT :limit")
    fun fetchAllRate(symbol:String, limit : Int) : Flow<List<Rate>>

    @Query("SELECT * FROM rate_table WHERE date=:date AND toCurrency=:symbol LIMIT 1")
    fun fetchSingleRate(date: String, symbol : String): Flow<Rate>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun bulkInsertRate(data : List<Rate>)
}