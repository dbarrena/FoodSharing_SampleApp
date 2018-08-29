package diegob.foodsharing.di.component

import dagger.Component
import diegob.foodsharing.BaseApp
import diegob.foodsharing.di.module.ApplicationModule

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(application: BaseApp)
}