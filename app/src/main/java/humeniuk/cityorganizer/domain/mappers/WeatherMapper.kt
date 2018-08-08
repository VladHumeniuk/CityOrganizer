package humeniuk.cityorganizer.domain.mappers

import humeniuk.cityorganizer.api.weather.response.WeatherResponse
import humeniuk.cityorganizer.domain.entity.Weather
import humeniuk.cityorganizer.domain.entity.WeatherType

class WeatherMapper() {

    fun map(weatherResponse: WeatherResponse) : Weather {
        val weather = Weather();
        weather.humidity = weatherResponse.data!!.humidity
        weather.temperature = weatherResponse.data.temp
        weather.maxTemperature = weatherResponse.data.maxTemp
        weather.minTemperature = weatherResponse.data.minTemp
        weather.pressure = weatherResponse.data.pressure
        weather.windSpeed = weatherResponse.wind!!.speed
        weather.type = WeatherType.fromName(weatherResponse.description!!.get(0).main)
        return weather;
    }
}