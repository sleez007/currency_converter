package ng.etokakingsley.cowrywise_converter.internal

interface NetworkCb<T> {
    fun success(response: T)
    fun error(message : String)
}