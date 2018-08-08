package humeniuk.cityorganizer.domain.interactor

import humeniuk.cityorganizer.api.WeatherApi
import humeniuk.cityorganizer.api.weather.response.WeatherResponse
import humeniuk.cityorganizer.domain.entity.Weather
import humeniuk.cityorganizer.domain.mappers.WeatherMapper
import io.reactivex.Observable

class WeatherNetInteractor(private val api : WeatherApi,
                           private val mapper : WeatherMapper) : WeatherInteractor {

    override fun getWeather(cityName: String): Observable<Weather> {
        return api.getWeather(cityName)
                .map { weatherResponse : WeatherResponse -> mapper.map(weatherResponse) }
    }
}