package ng.etokakingsley.cowrywise_converter.repository.dataSource.local

import kotlinx.coroutines.flow.Flow
import ng.etokakingsley.cowrywise_converter.db.entities.Rate
import ng.etokakingsley.cowrywise_converter.network.response.BaseModel

interface LocalDS {
    fun fetchSingleRate(date: String, symbol : String): Flow<Rate>
    fun fetchAllRate(symbol : String): Flow<List<Rate>>
    suspend fun bulkInsertRate(data : BaseModel)
}