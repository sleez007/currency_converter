package ng.etokakingsley.cowrywise_converter.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ng.etokakingsley.cowrywise_converter.db.dao.RateDao
import ng.etokakingsley.cowrywise_converter.db.entities.Rate

@Database(entities = [Rate::class], version = 1, exportSchema = false)
abstract class RateDB: RoomDatabase() {
    abstract fun getRateDao(): RateDao
}