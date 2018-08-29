package diegob.foodsharing.di.component

import dagger.Component
import diegob.foodsharing.di.module.FragmentModule
import diegob.foodsharing.ui.basket.BasketFragment

@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

    fun inject(fragment: BasketFragment)

}