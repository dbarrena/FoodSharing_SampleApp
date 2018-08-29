package diegob.foodsharing

import android.app.Application
import diegob.foodsharing.di.component.ApplicationComponent
import diegob.foodsharing.di.component.DaggerApplicationComponent
import diegob.foodsharing.di.module.ApplicationModule

class BaseApp: Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        setup()

        if(BuildConfig.DEBUG) {

        }
    }

    fun setup() {
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }

    companion object {
        lateinit var instance: BaseApp private set
    }
}