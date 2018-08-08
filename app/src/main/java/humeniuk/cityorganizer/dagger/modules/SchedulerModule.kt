package humeniuk.cityorganizer.dagger.modules

import dagger.Module
import io.reactivex.android.schedulers.AndroidSchedulers
import dagger.Provides
import humeniuk.cityorganizer.dagger.IO_SCHEDULER
import humeniuk.cityorganizer.dagger.UI_SCHEDULER
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Named

@Module
class SchedulerModule() {

    @Provides
    @Named(IO_SCHEDULER)
    fun provideIoScheduler(): Scheduler {
        return Schedulers.io()
    }

    @Provides
    @Named(UI_SCHEDULER)
    fun provideUiScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}