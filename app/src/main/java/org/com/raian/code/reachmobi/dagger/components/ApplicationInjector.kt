package org.com.raian.code.reachmobi.dagger.components

import dagger.Component
import org.com.raian.code.reachmobi.application.CustomApp
import org.com.raian.code.reachmobi.dagger.modules.AppModule

@Component(
    modules = [
        AppModule::class
    ]
)
interface ApplicationInjector {

    fun inject(customApp: CustomApp)

    @Component.Builder
    interface Builder {
        fun build():ApplicationInjector
        fun appModule(appModule: AppModule): Builder
    }
}