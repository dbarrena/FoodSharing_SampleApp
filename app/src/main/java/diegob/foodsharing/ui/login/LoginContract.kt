package diegob.foodsharing.ui.login

import diegob.foodsharing.ui.base.BaseContract

class LoginContract {

    interface View : BaseContract.View {
        fun showProgress(show: Boolean)
        fun loginResult(result: Boolean)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun checkLogin(user: String, password: String)
        fun checkCurrentVersion()
    }
}