package org.com.raian.code.reachmobi.application

import android.app.Application
import org.com.raian.code.reachmobi.dagger.components.DaggerApplicationInjector
import org.com.raian.code.reachmobi.dagger.modules.AppModule

class CustomApp : Application() {

    private val injector = DaggerApplicationInjector.builder()
        .appModule(AppModule(this))
        .build()

    override fun onCreate() {
        super.onCreate().also {
            inject()
        }
    }

    private fun inject() {
        injector.inject(this)
    }

    companion object {
        lateinit var instance: CustomApp private set
    }

}