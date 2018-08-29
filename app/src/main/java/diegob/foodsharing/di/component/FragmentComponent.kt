package diegob.foodsharing.di.component

import dagger.Component
import diegob.foodsharing.di.module.FragmentModule

@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {
    fun inject(fragmentModule: FragmentModule)
}