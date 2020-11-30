package ng.etokakingsley.cowrywise_converter.di.module

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import ng.etokakingsley.cowrywise_converter.app.Constants
import ng.etokakingsley.cowrywise_converter.di.annotations.OkHttpInterceptor
import ng.etokakingsley.cowrywise_converter.network.ApiService
import ng.etokakingsley.cowrywise_converter.network.interceptor.ConnectivityStatusInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideGSON(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun provideOkHttp(@OkHttpInterceptor connectivityStatusInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(connectivityStatusInterceptor).build()
    }

    @Provides
    @OkHttpInterceptor
    fun provideConnectivityInterceptor(@ApplicationContext context: Context): Interceptor {
        return ConnectivityStatusInterceptor(context)
    }

    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(Constants.base_url)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient).build()
    }

    @Singleton
    @Provides
    fun provideApiInterface(retrofit: Retrofit): ApiService {
        return  retrofit.create(ApiService::class.java)
    }
}