package humeniuk.cityorganizer

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import humeniuk.cityorganizer.dagger.components.DaggerAppComponent

class CityOrganizerApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}