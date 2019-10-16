package org.com.raian.code.reachmobi.dagger.modules

import dagger.Module
import dagger.Provides
import dagger.Reusable
import org.com.raian.code.reachmobi.application.CustomApp

@Module
class AppModule(val app: CustomApp) {

    @Provides
    @Reusable
    fun providesApp() = app
}