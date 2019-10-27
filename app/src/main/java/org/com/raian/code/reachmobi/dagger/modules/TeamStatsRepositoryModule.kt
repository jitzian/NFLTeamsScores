package org.com.raian.code.reachmobi.dagger.modules

import dagger.Module
import dagger.Provides
import dagger.Reusable
import org.com.raian.code.reachmobi.model.repository.TeamStatisticsRepository

@Module
class TeamStatsRepositoryModule {
    @Provides
    @Reusable
    fun providesRepository() = TeamStatisticsRepository()
}