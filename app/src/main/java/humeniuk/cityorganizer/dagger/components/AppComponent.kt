package humeniuk.cityorganizer.dagger.components

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import humeniuk.cityorganizer.CityOrganizerApplication
import humeniuk.cityorganizer.dagger.modules.ApiModule
import humeniuk.cityorganizer.dagger.modules.AppModule
import javax.inject.Singleton
import android.app.Application
import dagger.BindsInstance
import humeniuk.cityorganizer.api.WeatherApi


@Singleton
@Component(modules = [ApiModule::class,
    AppModule::class,
    AndroidSupportInjectionModule::class])
interface AppComponent : AndroidInjector<CityOrganizerApplication> {

    fun getWeatherApi() : WeatherApi

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}