package diegob.foodsharing.ui.login

import android.util.Log
import diegob.foodsharing.api.ApiServiceInterface
import diegob.foodsharing.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginPresenter : LoginContract.Presenter {

    private val api: ApiServiceInterface = ApiServiceInterface.create()
    private val subscriptions = CompositeDisposable()
    private lateinit var view: LoginContract.View

    override fun checkLogin(user: String, password: String) {
        /* val subscribe = api
                .login(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { item: User ->
                            checkPassword(password)
                        },
                        { error ->
                            view.showErrorMessage(error.localizedMessage)
                            Log.e("LOGIN ERROR", error.localizedMessage)
                        }
                )

        subscriptions.add(subscribe) */

        checkPassword("test")
    }

    private fun checkPassword(password: String) {
        view.loginResult(true)
    }

    override fun checkCurrentVersion() {
        TODO("not implemented")
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: LoginContract.View) {
        this.view = view
    }
}