package ng.etokakingsley.cowrywise_converter.repository.dataSource.local

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import ng.etokakingsley.cowrywise_converter.db.dao.RateDao
import javax.inject.Inject

class LocalDSImpl @Inject constructor(private val rateDao: RateDao,private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO) : LocalDS{

}