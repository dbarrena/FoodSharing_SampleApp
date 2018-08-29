package diegob.foodsharing.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import diegob.foodsharing.R
import diegob.foodsharing.di.module.ActivityModule
import diegob.foodsharing.ui.base.BaseActivity
import diegob.foodsharing.ui.basket.BasketFragment

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rootLayoutID = R.id.root

        if (savedInstanceState == null) {
            navigateTo(BasketFragment(), false)
        }
    }

    fun navigateTo(fragment: Fragment, addToBackstack: Boolean) {
        val transaction = supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment)

        if (addToBackstack) {
            transaction.addToBackStack(null)
        }

        transaction.commit()
    }

}
