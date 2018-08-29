package diegob.foodsharing.di.module

import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private var fragment: Fragment) {

    @Provides
    fun provideFragment(): Fragment {
        return fragment
    }
}