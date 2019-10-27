package org.com.raian.code.reachmobi.dagger.components

import dagger.Component
import org.com.raian.code.reachmobi.dagger.modules.NetworkModule
import org.com.raian.code.reachmobi.dagger.modules.TeamStatsRepositoryModule
import org.com.raian.code.reachmobi.dagger.modules.TeamsRepositoryModule
import org.com.raian.code.reachmobi.ui.showTeams.viewmodel.ShowTeamsViewModel
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        TeamsRepositoryModule::class,
        TeamStatsRepositoryModule::class
    ]
)
interface ComponentInjector {

    fun inject(showTeamsViewModel: ShowTeamsViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ComponentInjector
        fun networkModule(networkModule: NetworkModule): Builder
        fun teamRepositoryModule(teamsRepositoryModule: TeamsRepositoryModule): Builder
        fun teamStatisticsModule(teamStatsRepositoryModule: TeamStatsRepositoryModule): Builder

    }

}