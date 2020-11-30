package ng.etokakingsley.cowrywise_converter.repository.dataSource.remote

import kotlinx.coroutines.Deferred
import ng.etokakingsley.cowrywise_converter.internal.NoConnectivityException
import ng.etokakingsley.cowrywise_converter.network.ApiService
import ng.etokakingsley.cowrywise_converter.helper.Result
import ng.etokakingsley.cowrywise_converter.network.response.BaseModel
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RemoteDSImpl @Inject constructor(private  val apiService: ApiService) : RemoteDS{
    override suspend fun requestAllRate(accessKey: String):Result<BaseModel> {
        val deferred = apiService.loadAllRatesAsync(accessKey)
        return handleResponseMapping(deferred)
    }

    override suspend fun requestSingleRate(accessKey: String, symbol: String):Result<BaseModel> {
        val deferred = apiService.loadParticularRateAsync(accessKey,symbol)
        return handleResponseMapping(deferred)
    }

    private suspend fun handleResponseMapping(deferred : Deferred<BaseModel>) : Result<BaseModel> {
        return  try{
            val data = deferred.await()
            when(data.success){
                true -> Result.Success(data)
                false -> Result.Error(Exception("Error occurred"))
            }
        }catch(ex : java.lang.Exception){
            manageErrors(ex)
        }
    }

    private fun manageErrors(ex: Exception): Result.Error{
        val msg = when(ex){
            is NoConnectivityException ->{
                "No Internet Connectivity"
            }
            is IOException ->{
                "Could not connect, Please try again"
            }
            is HttpException ->{
                when(ex.code()){
                    422 ->{
                        "Unable to create/modify resource"
                    }
                    else-> ex.message()
                }
            }
            else -> {
                "Please Try again ${ex.message}"
            }

        }
        return Result.Error(Exception(msg))
    }

}