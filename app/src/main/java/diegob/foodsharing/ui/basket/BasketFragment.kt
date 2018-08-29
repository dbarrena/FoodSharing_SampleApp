package diegob.foodsharing.ui.basket


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.*
import diegob.foodsharing.R
import diegob.foodsharing.di.component.DaggerFragmentComponent
import diegob.foodsharing.di.module.FragmentModule
import diegob.foodsharing.ui.main.MainActivity
import diegob.foodsharing.utils.NavigationIconClickListener
import kotlinx.android.synthetic.main.fragment_basket.*
import kotlinx.android.synthetic.main.fragment_basket.view.*
import javax.inject.Inject

class BasketFragment : Fragment(), BasketContract.View {
    @Inject
    lateinit var presenter: BasketContract.Presenter
    private lateinit var activity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        injectDependency()
        activity = getActivity() as MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_basket, container, false)

        (activity as AppCompatActivity).setSupportActionBar(view.app_bar)
        view.app_bar.setNavigationOnClickListener(
                NavigationIconClickListener(activity, view.basket_content))

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?, menuInflater: MenuInflater?) {
        menuInflater!!.inflate(R.menu.toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, menuInflater)
    }

    override fun showProgress(show: Boolean) {
    }

    override fun showErrorMessage(error: String) {
    }

    private fun injectDependency() {
        val fragmentComponent = DaggerFragmentComponent.builder()
                .fragmentModule(FragmentModule(this))
                .build()

        fragmentComponent.inject(this)
    }

}
