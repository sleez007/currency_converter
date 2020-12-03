package ng.etokakingsley.cowrywise_converter.app

import android.app.Application
import android.content.SharedPreferences
import dagger.hilt.android.HiltAndroidApp
import ng.etokakingsley.cowrywise_converter.R
import ng.etokakingsley.cowrywise_converter.helper.ThemeHelper
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class App: Application() {
    @Inject
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate() {
        super.onCreate()
        setUpLogger()
        initializeTheme()
    }

    private fun setUpLogger() {
        Timber.plant(Timber.DebugTree())
    }
    private fun initializeTheme(){
        val theme = sharedPreferences.getString(resources.getString(R.string.preference_key_theme_option), Constants.THEME_DEFAULT)
        theme?.let {
            ThemeHelper.applyTheme(it)
        }
    }
}