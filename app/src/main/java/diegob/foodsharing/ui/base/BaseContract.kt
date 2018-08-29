package diegob.foodsharing.ui.base

class BaseContract {

    interface Presenter<in T> {
        fun unsubscribe()
        fun attach(view: T)
    }

    interface View {
        fun showErrorMessage(error: String)
    }
}