package ng.etokakingsley.cowrywise_converter.bindings

import android.widget.Button
import androidx.databinding.BindingAdapter
import ng.etokakingsley.cowrywise_converter.R

//Typograpghy binding


//button binds
@BindingAdapter("loadStat")
fun Button.loadStat(isLoading : Boolean){
    when(isLoading){
        true->{
           text = context.getString(R.string.loading)
            isEnabled = false
        }
        false->{
            text = context.getText(R.string.convert)
            isEnabled = true
        }
    }
}