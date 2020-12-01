package ng.etokakingsley.cowrywise_converter.repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import ng.etokakingsley.cowrywise_converter.R
import ng.etokakingsley.cowrywise_converter.db.entities.Rate
import ng.etokakingsley.cowrywise_converter.helper.Result
import ng.etokakingsley.cowrywise_converter.internal.NetworkCb
import ng.etokakingsley.cowrywise_converter.repository.dataSource.local.LocalDS
import ng.etokakingsley.cowrywise_converter.repository.dataSource.remote.RemoteDS
import javax.inject.Inject

class AppRepositoryImp @Inject constructor(private val localDS: LocalDS, private val remoteDS: RemoteDS,@ApplicationContext private val context: Context): AppRepository {
    override suspend fun requestAllRate(cb: NetworkCb<String>) {
        val accessKey = context.getString(R.string.access_token)
        when(val data = remoteDS.requestAllRate(accessKey)){
            is Result.Success ->{
                localDS.bulkInsertRate(data.data)
                cb.success("Fetched")
            }
            is Result.Error ->{
                cb.error(data.exception.message ?: context.getString(R.string.connection_error))
            }
        }
    }

    override suspend fun requestSingleRate(cb: NetworkCb<String>, symbol: String) {
        val accessKey = context.getString(R.string.access_token)
        //val data = remoteDS.requestSingleRate(accessKey, symbol)
        when(val data = remoteDS.requestAllRate(accessKey)){
            is Result.Success ->{
                cb.success("Fetched")
            }
            is Result.Error ->{
                cb.error(data.exception.message ?: context.getString(R.string.connection_error))
            }
        }
    }

    override fun fetchSingleRate(date: String, symbol: String): Flow<Rate> = localDS.fetchSingleRate(date, symbol)

    override fun fetchAllRate(): Flow<List<Rate>> =  localDS.fetchAllRate()

}