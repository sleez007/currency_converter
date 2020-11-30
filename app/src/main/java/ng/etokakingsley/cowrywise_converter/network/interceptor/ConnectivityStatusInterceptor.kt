package ng.etokakingsley.cowrywise_converter.network.interceptor

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import ng.etokakingsley.cowrywise_converter.internal.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response

class ConnectivityStatusInterceptor constructor(val context: Context): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if(!isOnline()) throw  NoConnectivityException()
        return chain.proceed(chain.request())
    }

    private fun isOnline(): Boolean{
        val connectivityManager : ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M){
            val nw = connectivityManager.activeNetwork ?: return false
            val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
            when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                //for other device how are able to connect with Ethernet
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        }else{
            val actNw = connectivityManager.activeNetworkInfo
            return  actNw != null && actNw.isConnected()
        }
        return networkInfo
    }

}