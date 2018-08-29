package diegob.foodsharing.di.component

import android.app.Activity
import dagger.Component
import diegob.foodsharing.di.module.ActivityModule
import diegob.foodsharing.ui.login.LoginActivity

@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(loginActivity: LoginActivity)
}