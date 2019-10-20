package org.com.raian.code.reachmobi.model.repository

import dagger.Lazy
import org.com.raian.code.reachmobi.application.CustomApp
import org.com.raian.code.reachmobi.dagger.components.DaggerDataBaseInjector
import org.com.raian.code.reachmobi.dagger.modules.DataBaseModule
import org.com.raian.code.reachmobi.model.base.BaseRepository
import org.com.raian.code.reachmobi.model.database.TeamsDataBase
import org.com.raian.code.reachmobi.model.database.model.TeamDataClass
import java.util.logging.Logger
import javax.inject.Inject

class TeamsRepository : BaseRepository() {

    @Inject
    lateinit var db: Lazy<TeamsDataBase>

    private val injector = DaggerDataBaseInjector.builder()
        .dataBaseModule(DataBaseModule(CustomApp.instance))
        .build()

    init {
        TAG = TeamsRepository::class.java.simpleName
        logger = Logger.getLogger(TAG)
        inject()
    }

    private fun inject() {
        injector.inject(this)
    }

    fun insert(teamDataClass: TeamDataClass) {
        db.get().teamDao().insert(teamDataClass)
    }

    fun getAll() = db.get().teamDao().getAll()

    fun getAllByStatus(status: Boolean) = db.get().teamDao().getAllByStatus(status)

}