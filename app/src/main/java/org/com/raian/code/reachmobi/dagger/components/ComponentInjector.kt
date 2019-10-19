package org.com.raian.code.reachmobi.dagger.components

import dagger.Component
import org.com.raian.code.reachmobi.dagger.modules.NetworkModule
import org.com.raian.code.reachmobi.ui.showTeams.viewmodel.ShowTeamsViewModel
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class
    ]
)
interface ComponentInjector {

    fun inject(showTeamsViewModel: ShowTeamsViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ComponentInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }

}