package humeniuk.cityorganizer.domain.interactor

import humeniuk.cityorganizer.domain.entity.Weather
import io.reactivex.Observable

interface WeatherInteractor {

    fun getWeather(cityName : String) : Observable<Weather>
}