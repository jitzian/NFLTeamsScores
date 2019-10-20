package org.com.raian.code.reachmobi.dagger.components

import dagger.Component
import org.com.raian.code.reachmobi.dagger.modules.RepositoryModule
import org.com.raian.code.reachmobi.ui.addTeams.viewmodel.AddTeamsViewModel

@Component(
    modules = [RepositoryModule::class]
)
interface RepositoryInjector {

    fun inject(addTeamsViewModel: AddTeamsViewModel)

    @Component.Builder
    interface Builder{
        fun build(): RepositoryInjector
        fun repositoryModule(repositoryModule: RepositoryModule): Builder
    }
}