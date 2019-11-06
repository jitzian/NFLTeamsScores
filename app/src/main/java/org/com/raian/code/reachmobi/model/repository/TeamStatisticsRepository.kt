package org.com.raian.code.reachmobi.model.repository

import dagger.Lazy
import org.com.raian.code.reachmobi.application.CustomApp
import org.com.raian.code.reachmobi.dagger.components.DaggerDataBaseInjector
import org.com.raian.code.reachmobi.dagger.modules.DataBaseModule
import org.com.raian.code.reachmobi.model.base.BaseRepository
import org.com.raian.code.reachmobi.model.database.TeamsDataBase
import org.com.raian.code.reachmobi.model.database.model.TeamStatistics
import java.util.logging.Logger
import javax.inject.Inject

class TeamStatisticsRepository : BaseRepository() {

    private val injector = DaggerDataBaseInjector.builder()
        .dataBaseModule(DataBaseModule(CustomApp.instance))
        .build()

    @Inject
    lateinit var db: Lazy<TeamsDataBase>

    init {
        TAG = TeamStatisticsRepository::class.java.simpleName
        logger = Logger.getLogger(TAG)
        inject()
    }

    private fun inject() {
        injector.inject(this)
    }

    fun insert(teamStatistics: TeamStatistics) {
        db.get().teamStatisticsDao().insert(teamStatistics)
    }

    fun update(teamStatistics: TeamStatistics) {
        db.get().teamStatisticsDao().update(teamStatistics)
    }

    fun getAllByTeamId(teamId: String) = db.get().teamStatisticsDao().getAllByTeamId(teamId)

    fun deleteAll() {
        db.get().teamStatisticsDao().deleteAll()
    }

    fun deleteByTeamId(teamId: String) {
        db.get().teamStatisticsDao().deleteByTeamId(teamId)
    }

    override fun closeDB() {
        db.get().close()
    }
}