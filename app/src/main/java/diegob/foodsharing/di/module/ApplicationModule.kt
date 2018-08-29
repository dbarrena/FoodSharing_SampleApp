package diegob.foodsharing.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import diegob.foodsharing.BaseApp

@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return baseApp
    }
}