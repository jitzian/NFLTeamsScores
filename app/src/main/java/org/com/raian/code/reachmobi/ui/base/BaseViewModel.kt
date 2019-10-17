package org.com.raian.code.reachmobi.ui.base

import androidx.lifecycle.ViewModel
import org.com.raian.code.reachmobi.rest.RestApi
import java.util.logging.Logger

abstract class BaseViewModel : ViewModel(){
    protected lateinit var TAG: String
    protected lateinit var logger: Logger
    protected lateinit var restApi: RestApi
}