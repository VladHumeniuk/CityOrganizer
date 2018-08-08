package humeniuk.cityorganizer.domain.interactor

import humeniuk.cityorganizer.domain.entity.City
import humeniuk.cityorganizer.domain.entity.Weather
import io.reactivex.Observable

class LoadCityInfoInteractorImpl(private val weatherInteractor: WeatherInteractor) : LoadCityInfoInteractor {

    override fun loadCityInfo(city: City) : Observable<City> {
        return weatherInteractor.getWeather(city.name
        ).map { weather : Weather ->
            city.weather = weather
            city
        }
    }
}