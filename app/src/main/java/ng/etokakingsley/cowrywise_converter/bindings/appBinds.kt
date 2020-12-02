package ng.etokakingsley.cowrywise_converter.bindings

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import ng.etokakingsley.cowrywise_converter.R

//Typograpghy binding
@BindingAdapter("toggleSelected")
fun TextView.toggleSelected(isSelected : Boolean){
    when(isSelected){
        true -> setTextColor(ContextCompat.getColor(context, R.color.white))
        false ->setTextColor(ContextCompat.getColor(context, R.color.grey))
    }
}

//ImagView bindings
@BindingAdapter("toggleSelected")
fun ImageView.toggleSelected(isSelected : Boolean){
    when(isSelected){
//        true -> setColorFilter(ContextCompat.getColor(context, R.color.brand_green), android.graphics.PorterDuff.Mode.SRC_IN)
//        false ->setColorFilter(ContextCompat.getColor(context, R.color.grey), android.graphics.PorterDuff.Mode.SRC_IN)
        true -> visibility = View.VISIBLE
        false->visibility = View.INVISIBLE
    }
}

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