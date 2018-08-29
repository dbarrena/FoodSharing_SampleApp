package diegob.foodsharing.ui.basket


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.*
import diegob.foodsharing.R
import diegob.foodsharing.utils.NavigationIconClickListener
import kotlinx.android.synthetic.main.fragment_basket.*
import kotlinx.android.synthetic.main.fragment_basket.view.*

class BasketFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_basket, container, false)

        (activity as AppCompatActivity).setSupportActionBar(view.app_bar)
        view.app_bar.setNavigationOnClickListener(
                NavigationIconClickListener(activity!!, view.basket_content))

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, menuInflater: MenuInflater?) {
        menuInflater!!.inflate(R.menu.toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, menuInflater)
    }

}
