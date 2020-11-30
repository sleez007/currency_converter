package ng.etokakingsley.cowrywise_converter.network

import kotlinx.coroutines.Deferred
import ng.etokakingsley.cowrywise_converter.network.response.BaseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/latest")
    fun loadAllRatesAsync(@Query("access_key") accessKey : String, @Query("format") format : Int =1): Deferred<BaseModel>

    @GET("/latest")
    fun loadParticularRate(@Query("access_key") accessKey : String,@Query("symbols") symbols : String):Deferred<BaseModel>
}