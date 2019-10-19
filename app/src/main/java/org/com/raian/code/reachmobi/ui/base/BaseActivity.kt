package org.com.raian.code.reachmobi.ui.base

import androidx.appcompat.app.AppCompatActivity
import java.util.logging.Logger

abstract class BaseActivity: AppCompatActivity(){
    protected lateinit var TAG: String
    protected lateinit var logger: Logger

    abstract fun initView()
}