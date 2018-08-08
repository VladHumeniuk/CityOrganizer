package humeniuk.cityorganizer.dagger.modules

import dagger.Module
import humeniuk.cityorganizer.domain.mappers.WeatherMapper

@Module
class MapperModule() {

    fun provideWeatherMapper() : WeatherMapper {
        return WeatherMapper()
    }
}