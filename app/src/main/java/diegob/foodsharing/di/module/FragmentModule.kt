package diegob.foodsharing.di.module

import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides
import diegob.foodsharing.ui.basket.BasketContract
import diegob.foodsharing.ui.basket.BasketPresenter

@Module
class FragmentModule(private var fragment: Fragment) {

    @Provides
    fun provideFragment(): Fragment {
        return fragment
    }

    @Provides
    fun provideBasketPresenter(): BasketContract.Presenter {
        return BasketPresenter()
    }
}