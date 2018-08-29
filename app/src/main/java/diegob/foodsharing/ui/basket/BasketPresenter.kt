package diegob.foodsharing.ui.basket

import diegob.foodsharing.api.ApiServiceInterface
import diegob.foodsharing.ui.login.LoginContract
import io.reactivex.disposables.CompositeDisposable

class BasketPresenter : BasketContract.Presenter {

    private val api: ApiServiceInterface = ApiServiceInterface.create()
    private val subscriptions = CompositeDisposable()
    private lateinit var view: BasketContract.View

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: BasketContract.View) {
        this.view = view
    }

}