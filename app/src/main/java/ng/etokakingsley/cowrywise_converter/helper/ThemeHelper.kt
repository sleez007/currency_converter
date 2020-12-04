package ng.etokakingsley.cowrywise_converter.helper

import android.os.Build
import androidx.appcompat.app.AppCompatDelegate
import ng.etokakingsley.cowrywise_converter.app.Constants.THEME_DARK
import ng.etokakingsley.cowrywise_converter.app.Constants.THEME_LIGHT

/**
 * @desc This helper class handles swiching of themes
 */
object ThemeHelper {
    fun applyTheme(themePref: String) {
        when (themePref) {
            THEME_LIGHT -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            THEME_DARK -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            else -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY)
                }
            }
        }
    }
}