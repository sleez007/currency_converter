package ng.etokakingsley.cowrywise_converter.ui.home

import android.content.Context
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import ng.etokakingsley.cowrywise_converter.db.entities.Rate
import ng.etokakingsley.cowrywise_converter.helper.CustomLiveData
import ng.etokakingsley.cowrywise_converter.helper.Event
import ng.etokakingsley.cowrywise_converter.internal.NetworkCb
import ng.etokakingsley.cowrywise_converter.internal.TabEnum
import ng.etokakingsley.cowrywise_converter.repository.AppRepository
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

class HomeViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val appRepository: AppRepository,
    @ApplicationContext context: Context
) : ViewModel(), NetworkCb<String> {
    val flashErrorMessage =   MutableLiveData<Event<String>>()
    val flashSuccessMessage = MutableLiveData<Event<String>>()
    val initialTo = MutableLiveData<String>("PLN")
    val isLoading = MutableLiveData<Boolean>(false)
    val from = MutableLiveData<String>("1")

    val currentTab = MutableLiveData<TabEnum>(TabEnum.THIRTY_DAYS_TAB)

    val rates: LiveData<List<Rate>> = Transformations.switchMap(CustomLiveData(initialTo,currentTab)){
        if(it.first!= null && it.second!=null){
            val limit: Int = when(it.second!!){
               TabEnum.THIRTY_DAYS_TAB ->30
                TabEnum.NINETY_DAYS_TAB->90
            }
            appRepository.fetchAllRate(it.first!!,limit ).asLiveData()
        }else{
            null
        }

    }

    val currentRate : LiveData<Rate> = Transformations.switchMap(initialTo){
        it?.let {
            appRepository.fetchSingleRate(retrieveDate(), it).asLiveData()
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

    fun requestSingleRate(symbol: String){
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

    fun formattedVal(rate: Rate?, from: String?):String{
        return if(rate!=null && from!=null && from.trim()!="" ) (rate.rate* from.toDouble()).toString() else "0.0"
    }

    fun switchTabs(tab: TabEnum){
        currentTab.value = tab
    }

    fun switchCurrency(selectedCurrency: String){
        initialTo.value = selectedCurrency
    }

    private fun retrieveDate(): String{
        val c: Date = Calendar.getInstance().getTime()
        val df = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        Timber.i(df.format(c))
        return  df.format(c)
    }

}