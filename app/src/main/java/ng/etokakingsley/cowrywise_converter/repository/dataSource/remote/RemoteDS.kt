package ng.etokakingsley.cowrywise_converter.repository.dataSource.remote

import ng.etokakingsley.cowrywise_converter.helper.Result
import ng.etokakingsley.cowrywise_converter.network.response.BaseModel

interface RemoteDS {
    suspend fun requestAllRate(accessKey : String): Result<BaseModel>
    suspend fun requestSingleRate(accessKey: String, symbol: String): Result<BaseModel>
}