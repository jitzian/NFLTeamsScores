package org.com.raian.code.reachmobi.dagger.modules

import dagger.Module
import dagger.Provides
import dagger.Reusable
import org.com.raian.code.reachmobi.model.repository.TeamsRepository

@Module
class TeamsRepositoryModule {
    @Provides
    @Reusable
    fun providesRepository() = TeamsRepository()
}