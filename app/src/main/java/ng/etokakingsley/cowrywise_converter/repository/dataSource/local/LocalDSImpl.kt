package ng.etokakingsley.cowrywise_converter.repository.dataSource.local

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import ng.etokakingsley.cowrywise_converter.db.dao.RateDao
import ng.etokakingsley.cowrywise_converter.db.entities.Rate
import ng.etokakingsley.cowrywise_converter.domain.NetworkToCache
import ng.etokakingsley.cowrywise_converter.network.response.BaseModel
import javax.inject.Inject

class LocalDSImpl @Inject constructor(private val rateDao: RateDao,private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO) : LocalDS{
    override fun fetchSingleRate(date: String, symbol: String): Flow<Rate> = rateDao.fetchSingleRate(date, symbol)
    override fun fetchAllRate(): Flow<List<Rate>> = rateDao.fetchAllRate()
    override suspend fun bulkInsertRate(data:BaseModel){
        withContext(ioDispatcher){
            val list : List<Rate> = NetworkToCache.convertNetworkRateToCacheRate(data)
            rateDao.bulkInsertRate(list)
        }
    }

}