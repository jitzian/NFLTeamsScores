package org.com.raian.code.reachmobi.dagger.components

import dagger.Component
import org.com.raian.code.reachmobi.dagger.modules.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class
    ]
)
interface ComponentInjector {

    @Component.Builder
    interface Builder {
        fun build(): ComponentInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }

}