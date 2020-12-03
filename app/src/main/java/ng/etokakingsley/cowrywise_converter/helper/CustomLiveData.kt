package ng.etokakingsley.cowrywise_converter.helper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

class CustomLiveData<A, B>(a: LiveData<A>, b: LiveData<B>) : MediatorLiveData<Pair<A?, B?>>() {
    init {
        addSource(a) { value = it to b.value }
        addSource(b) { value = a.value to it }
    }
}

