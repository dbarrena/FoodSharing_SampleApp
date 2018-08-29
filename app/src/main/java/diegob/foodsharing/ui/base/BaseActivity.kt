package diegob.foodsharing.ui.base

import android.annotation.SuppressLint
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import diegob.foodsharing.R
import diegob.foodsharing.utils.ConnectivityReceiver
import diegob.foodsharing.utils.Utils

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity(), ConnectivityReceiver.ConnectivityReceiverListener {
    private var snackBar: Snackbar? = null
    var rootLayoutID: Int? = null
    var isConnected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerReceiver(ConnectivityReceiver(),
                IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

    private fun toggleConnectionMessage(isConnected: Boolean) {
        if (!isConnected) {
            val messageToUser = getString(R.string.offline_message)
            onDisconnectedListener?.onDisconnected()
            val utils = Utils()
            if (rootLayoutID != null) {
                snackBar = utils.showSnackBar(findViewById(rootLayoutID!!), messageToUser,
                        resources.getColor(R.color.colorAccent), Snackbar.LENGTH_INDEFINITE)
                snackBar?.show()
            }

        } else {
            snackBar?.dismiss()
            onConnectedListener?.onConnectionAvailable()
        }
    }

    fun showMessage(message: String) {
        val utils = Utils()
        if (rootLayoutID != null) {
            snackBar = utils.showSnackBar(findViewById(rootLayoutID!!), message,
                    resources.getColor(R.color.colorAccent), Snackbar.LENGTH_LONG)
            snackBar?.show()
        }
    }

    override fun onResume() {
        super.onResume()
        ConnectivityReceiver.connectivityReceiverListener = this
    }

    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        toggleConnectionMessage(isConnected)
        this.isConnected = isConnected
    }

    interface OnConnectionAvailableListener {
        fun onConnectionAvailable()
    }

    interface OnDisconnectedListener {
        fun onDisconnected()
    }

    companion object {
        var onConnectedListener: OnConnectionAvailableListener? = null
        var onDisconnectedListener: OnDisconnectedListener? = null
    }
}