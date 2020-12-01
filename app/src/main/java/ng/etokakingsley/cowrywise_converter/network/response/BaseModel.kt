package ng.etokakingsley.cowrywise_converter.network.response

data class BaseModel(
    val success : Boolean,
    val timestamp : Long,
    val base : String,
    val date : String,
    val rates : NetworkRate
)