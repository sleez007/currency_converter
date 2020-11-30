package ng.etokakingsley.cowrywise_converter.ui.home

import android.content.Context
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import ng.etokakingsley.cowrywise_converter.helper.Event
import ng.etokakingsley.cowrywise_converter.repository.AppRepository

class HomeViewModel @ViewModelInject constructor(@Assisted private val savedStateHandle: SavedStateHandle, val appRepository: AppRepository, @ApplicationContext context: Context) : ViewModel() {
    val flashErrorMessage =   MutableLiveData<Event<String>>()
    val flashSuccessMessage = MutableLiveData<Event<String>>()
    val initialTo = MutableLiveData<String>("PLN")
    val isLoading = MutableLiveData<Boolean>(false)
    init {
        requestData()
    }
    fun requestData(){

    }
}