package diegob.foodsharing.ui.basket

import diegob.foodsharing.ui.base.BaseContract

class BasketContract {
    interface View : BaseContract.View {
        fun showProgress(show: Boolean)
    }

    interface Presenter : BaseContract.Presenter<View> {
    }
}