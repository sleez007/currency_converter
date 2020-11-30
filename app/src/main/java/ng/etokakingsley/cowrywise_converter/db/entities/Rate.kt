package ng.etokakingsley.cowrywise_converter.db.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "rate_table", indices =[Index(value = ["base","toCurrency", "date"], unique = true)])
data class Rate(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val timeStamp : Long,
    val base : String,
    val date : String,
    val toCurrency : String,
    val rate : Double
)