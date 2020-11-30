package ng.etokakingsley.cowrywise_converter.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import ng.etokakingsley.cowrywise_converter.db.CoinDB
import ng.etokakingsley.cowrywise_converter.db.dao.RateDao
import ng.etokakingsley.cowrywise_converter.repository.AppRepository
import ng.etokakingsley.cowrywise_converter.repository.AppRepositoryImp
import ng.etokakingsley.cowrywise_converter.repository.dataSource.local.LocalDS
import ng.etokakingsley.cowrywise_converter.repository.dataSource.local.LocalDSImpl
import ng.etokakingsley.cowrywise_converter.repository.dataSource.remote.RemoteDS
import ng.etokakingsley.cowrywise_converter.repository.dataSource.remote.RemoteDSImpl
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context):CoinDB{
        return Room.databaseBuilder(context.applicationContext,CoinDB::class.java,"currency_converter.db").build()
    }

    @Provides
    fun provideRateDao(db: CoinDB): RateDao = db.getRateDao()

    @Singleton
    @Provides
    fun provideSharedPref(@ApplicationContext context: Context): SharedPreferences{
        return context.getSharedPreferences("appPrefs",Context.MODE_PRIVATE)
    }
}

@InstallIn(ApplicationComponent::class)
@Module
abstract class AppModuleBinds{
    @Singleton
    @Binds
    abstract fun bindRepository(appRepositoryImpl: AppRepositoryImp): AppRepository

    @Binds
    abstract fun bindLocalDataSource(localDSImpl: LocalDSImpl): LocalDS

    @Binds
    abstract fun bindRemoteDataSource(remoteDSImpl: RemoteDSImpl): RemoteDS

}