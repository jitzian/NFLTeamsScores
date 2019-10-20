package org.com.raian.code.reachmobi.dagger.modules

import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.Reusable
import org.com.raian.code.reachmobi.application.CustomApp
import org.com.raian.code.reachmobi.constants.GlobalConstants
import org.com.raian.code.reachmobi.model.database.TeamsDataBase

@Module
class DataBaseModule(private val context: CustomApp) {

    @Provides
    @Reusable
    fun providesDataBase() = Room
        .databaseBuilder(
            context,
            TeamsDataBase::class.java,
            GlobalConstants.dataBaseName)
        .build()

}