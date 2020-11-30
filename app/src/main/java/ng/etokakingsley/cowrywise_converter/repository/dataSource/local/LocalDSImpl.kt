package ng.etokakingsley.cowrywise_converter.repository.dataSource.local

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import ng.etokakingsley.cowrywise_converter.db.dao.RateDao
import ng.etokakingsley.cowrywise_converter.db.entities.Rate
import javax.inject.Inject

class LocalDSImpl @Inject constructor(private val rateDao: RateDao,private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO) : LocalDS{
    override fun fetchSingleRate(date: String, symbol: String): Flow<Rate> = rateDao.fetchSingleRate(date, symbol)
    override fun fetchAllRate(): Flow<List<Rate>> = rateDao.fetchAllRate()
    override suspend fun bulkInsertRate(data: List<Rate>) =rateDao.bulkInsertRate(data)

}