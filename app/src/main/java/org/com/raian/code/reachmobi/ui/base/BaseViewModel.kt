package org.com.raian.code.reachmobi.ui.base

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import org.com.raian.code.reachmobi.application.CustomApp
import org.com.raian.code.reachmobi.rest.RestApi
import java.util.logging.Logger

abstract class BaseViewModel : ViewModel(), CoroutineScope {
    protected lateinit var TAG: String
    protected lateinit var logger: Logger
    protected lateinit var restApi: RestApi

    //TODO: implement before making actual network call
    fun checkConnectivity() : Boolean{
        val cm = CustomApp.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }
}