package humeniuk.cityorganizer.api

import humeniuk.cityorganizer.api.weather.response.WeatherResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/weather")
    fun getWeather(@Query("q") city : String) : Observable<WeatherResponse>
}