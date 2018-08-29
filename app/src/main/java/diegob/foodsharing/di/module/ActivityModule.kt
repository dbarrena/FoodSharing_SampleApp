package diegob.foodsharing.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides
import diegob.foodsharing.ui.login.LoginActivity
import diegob.foodsharing.ui.login.LoginContract
import diegob.foodsharing.ui.login.LoginPresenter

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun provideLoginPresenter(): LoginContract.Presenter {
        return LoginPresenter()
    }

}