package ng.etokakingsley.cowrywise_converter.repository.dataSource.local

import kotlinx.coroutines.flow.Flow
import ng.etokakingsley.cowrywise_converter.db.entities.Rate

interface LocalDS {
    fun fetchSingleRate(date: String, symbol : String): Flow<Rate>
    fun fetchAllRate(): Flow<List<Rate>>
    suspend fun bulkInsertRate(data : List<Rate>)
}