package ng.etokakingsley.cowrywise_converter.ui.home

import android.content.Context
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import ng.etokakingsley.cowrywise_converter.db.entities.Rate
import ng.etokakingsley.cowrywise_converter.helper.Event
import ng.etokakingsley.cowrywise_converter.internal.NetworkCb
import ng.etokakingsley.cowrywise_converter.repository.AppRepository
import timber.log.Timber

class HomeViewModel @ViewModelInject constructor(@Assisted private val savedStateHandle: SavedStateHandle, val appRepository: AppRepository, @ApplicationContext context: Context) : ViewModel(), NetworkCb<String> {
    val flashErrorMessage =   MutableLiveData<Event<String>>()
    val flashSuccessMessage = MutableLiveData<Event<String>>()
    val initialTo = MutableLiveData<String>("PLN")
    val isLoading = MutableLiveData<Boolean>(false)
    val from = MutableLiveData<String>("1")

    val rates: LiveData<List<Rate>> = appRepository.fetchAllRate().asLiveData()

    val currentRate : LiveData<Rate> = Transformations.switchMap(initialTo){
        it?.let {
            appRepository.fetchSingleRate("2020-12-01", it).asLiveData()
        }
    }
    init {
        requestData()
    }
    private fun requestData(){
        viewModelScope.launch {
            isLoading.value = true
            appRepository.requestAllRate(this@HomeViewModel)
        }
    }

    fun requestSingleRate(symbol : String){
        initialTo.value = symbol
        viewModelScope.launch {
            isLoading.value = true
            appRepository.requestSingleRate(this@HomeViewModel, symbol)
        }
    }

    override fun success(response: String) {
        Timber.i(response)
        isLoading.value = false
        flashSuccessMessage.postValue(Event(response))
    }

    override fun error(message: String) {
        isLoading.value = false
        Timber.i(message)
        flashErrorMessage.postValue(Event(message))
    }

    fun formattedVal(rate: Rate?, from : String? ):String{
        return if(rate!=null && from!=null && from.trim()!="" ) (rate.rate* from.toDouble()).toString() else "0.0"
    }


}