package ng.etokakingsley.cowrywise_converter.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        setUpLogger()
        initializeTheme()
    }

    private fun setUpLogger() {
        Timber.plant(Timber.DebugTree())
    }
    private fun initializeTheme(){

    }
}