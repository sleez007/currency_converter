package ng.etokakingsley.cowrywise_converter.repository

import kotlinx.coroutines.flow.Flow
import ng.etokakingsley.cowrywise_converter.db.entities.Rate
import ng.etokakingsley.cowrywise_converter.internal.NetworkCb

interface AppRepository {
    suspend fun requestAllRate(cb:NetworkCb<String>)
    suspend fun requestSingleRate(cb:NetworkCb<String>, symbol: String)
    fun fetchSingleRate(date: String, symbol : String): Flow<Rate>
    fun fetchAllRate(): Flow<List<Rate>>
    suspend fun bulkInsertRate(data : List<Rate>)
}