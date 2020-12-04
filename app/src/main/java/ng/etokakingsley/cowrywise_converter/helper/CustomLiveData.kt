package ng.etokakingsley.cowrywise_converter.helper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

/**
 *@desc A generic class that allows us switchMaps based on changes in either of two livedata values
 */
class CustomLiveData<A, B>(a: LiveData<A>, b: LiveData<B>) : MediatorLiveData<Pair<A?, B?>>() {
    init {
        addSource(a) { value = it to b.value }
        addSource(b) { value = a.value to it }
    }
}

