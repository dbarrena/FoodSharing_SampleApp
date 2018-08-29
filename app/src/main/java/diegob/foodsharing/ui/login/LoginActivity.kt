package diegob.foodsharing.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import diegob.foodsharing.R
import diegob.foodsharing.di.component.DaggerActivityComponent
import diegob.foodsharing.di.module.ActivityModule
import diegob.foodsharing.ui.base.BaseActivity
import diegob.foodsharing.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginContract.View,
        BaseActivity.OnConnectionAvailableListener {

    @Inject
    lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        rootLayoutID = R.id.root
        injectDependency()
        onConnectedListener = this
        presenter.attach(this)

        login_button.setOnClickListener {
            if (isConnected) {
                showProgress(true)
                presenter.checkLogin(user_field.text.toString(),
                        password_field.text.toString())
            }
        }
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            progress_bar.visibility = View.VISIBLE
        } else {
            progress_bar.visibility = View.GONE
        }
    }

    override fun loginResult(result: Boolean) {
        showProgress(false)
        if (result) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else {
            showErrorMessage(getString(R.string.invalid_password))
        }
    }

    override fun showErrorMessage(error: String) {
        showProgress(false)
        showMessage(error)
    }

    override fun onConnectionAvailable() {
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .build()

        activityComponent.inject(this)
    }
}
