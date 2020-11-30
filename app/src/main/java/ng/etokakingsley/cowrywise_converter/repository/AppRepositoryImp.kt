package ng.etokakingsley.cowrywise_converter.repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import ng.etokakingsley.cowrywise_converter.repository.dataSource.local.LocalDS
import ng.etokakingsley.cowrywise_converter.repository.dataSource.remote.RemoteDS
import javax.inject.Inject

class AppRepositoryImp @Inject constructor(private val localDS: LocalDS, private val remoteDS: RemoteDS,@ApplicationContext private val context: Context): AppRepository {
}