package ng.etokakingsley.cowrywise_converter.helper

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import ng.etokakingsley.cowrywise_converter.R

/**
 * Utility class for showing snackbars
 */

object SnackBarUtil {
    fun errorSnack(
        view: View,
        msg: String,
        context: Context,
        duration: Int = Snackbar.LENGTH_LONG
    ): Snackbar {
        return Snackbar.make(view, msg, duration)
            .setBackgroundTint(ContextCompat.getColor(context, R.color.error_snack))
    }

    fun errorSnack(
        view: View,
        msg: String,
        context: Context,
        duration: Int = Snackbar.LENGTH_LONG,
        action: ()->Unit
    ): Snackbar {
        return Snackbar.make(view, msg, duration).setAction(context.getString(R.string.retry)) {
            action()
        }.setBackgroundTint(ContextCompat.getColor(context, R.color.error_snack))
    }

    fun successSnack(
        view: View,
        msg: String,
        context: Context,
        duration: Int = Snackbar.LENGTH_LONG
    ): Snackbar {

        return Snackbar.make(view, msg, duration)
        //.setBackgroundTint(ContextCompat.getColor(context, R.color.error_snack))
    }
}