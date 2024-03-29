package org.com.raian.code.reachmobi.dagger.components

import dagger.Component
import org.com.raian.code.reachmobi.dagger.modules.DataBaseModule
import org.com.raian.code.reachmobi.model.repository.TeamStatisticsRepository
import org.com.raian.code.reachmobi.model.repository.TeamsRepository

@Component(
    modules = [
        DataBaseModule::class
    ]
)
interface DataBaseInjector {

    fun inject(teamsRepository: TeamsRepository)
    fun inject(teamStatisticsRepository: TeamStatisticsRepository)

    @Component.Builder
    interface Builder{
        fun build(): DataBaseInjector
        fun dataBaseModule(dataBaseModule: DataBaseModule): Builder
    }

}