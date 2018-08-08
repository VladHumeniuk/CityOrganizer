package humeniuk.cityorganizer.domain.interactor

import humeniuk.cityorganizer.domain.entity.City
import io.reactivex.Observable

interface LoadCityInfoInteractor {

    fun loadCityInfo(city : City) : Observable<City>
}