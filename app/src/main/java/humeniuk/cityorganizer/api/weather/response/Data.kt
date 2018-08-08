package humeniuk.cityorganizer.api.weather.response

import com.google.gson.annotations.SerializedName

class Data() {

    val temp : Int = 0

    val pressure : Int = 0

    val humidity : Int = 0

    @SerializedName("temp_max")
    val maxTemp : Int = 0

    @SerializedName("temp_min")
    val minTemp : Int = 0
}