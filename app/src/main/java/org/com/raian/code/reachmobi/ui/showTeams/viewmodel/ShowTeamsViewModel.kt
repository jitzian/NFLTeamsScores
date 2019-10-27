package org.com.raian.code.reachmobi.ui.showTeams.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.Lazy
import kotlinx.coroutines.*
import org.com.raian.code.reachmobi.dagger.components.DaggerComponentInjector
import org.com.raian.code.reachmobi.dagger.modules.NetworkModule
import org.com.raian.code.reachmobi.dagger.modules.TeamStatsRepositoryModule
import org.com.raian.code.reachmobi.dagger.modules.TeamsRepositoryModule
import org.com.raian.code.reachmobi.model.database.model.TeamDataClass
import org.com.raian.code.reachmobi.model.database.model.TeamStatistics
import org.com.raian.code.reachmobi.model.repository.TeamStatisticsRepository
import org.com.raian.code.reachmobi.model.repository.TeamsRepository
import org.com.raian.code.reachmobi.rest.RestApi
import org.com.raian.code.reachmobi.rest.model.ResultApi
import org.com.raian.code.reachmobi.ui.base.BaseViewModel
import retrofit2.Retrofit
import java.util.logging.Logger
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ShowTeamsViewModel : BaseViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Job()

    private val injector = DaggerComponentInjector.builder()
        .networkModule(NetworkModule())
        .teamRepositoryModule(TeamsRepositoryModule())
        .teamStatisticsModule(TeamStatsRepositoryModule())
        .build()

    @Inject
    lateinit var retrofit: Lazy<Retrofit>

    @Inject
    lateinit var teamsRepository: TeamsRepository

    @Inject
    lateinit var teamStatsRepository: TeamStatisticsRepository

    private val listOfTeams by lazy {
        MutableLiveData<List<TeamDataClass>>()
    }

    fun getListOfTeamsUI(): LiveData<List<TeamDataClass>> {
        return listOfTeams
    }

    private val listOfFetchedTeams by lazy {
        MutableLiveData<List<ResultApi>>()
    }

    fun getListOfFetchedTeamsUI(): LiveData<List<ResultApi>> {
        return listOfFetchedTeams
    }

    private var listOfRemoteResults = ArrayList<ResultApi>()

    private val listOfTeamStatistics by lazy {
        MutableLiveData<List<TeamStatistics>>()
    }

    fun getListOfTeamStatistics(): LiveData<List<TeamStatistics>> {
        return listOfTeamStatistics
    }

    init {
        TAG = ShowTeamsViewModel::class.java.simpleName
        logger = Logger.getLogger(TAG)
        inject()
    }

    private fun inject() {
        injector.inject(this)
        restApi = retrofit.get().create(RestApi::class.java)
    }

    fun getSelectedTeamData() {
        launch {
            val selectedTeams = getLocalData()
            if (selectedTeams != null && selectedTeams.isNotEmpty()) {
                teamStatsRepository.deleteAll()
                for (item in selectedTeams) {
                    logger.severe("$TAG::getSelectedTeamData::${item}")
                    getRemoteData(item.teamName.toString())
                    getAllStatisticsByTeamId(item.teamName.toString())
                }
            }
        }
    }

    private suspend fun getLocalData(): List<TeamDataClass>? = coroutineScope {
        return@coroutineScope teamsRepository.db.get().teamDao().getAllByStatus(true)
    }

    private suspend fun getRemoteData(team: String) = coroutineScope {
        val deferredRemoteData = restApi.getResultsByTeam(team).execute()
        logger.severe("$TAG::getRemoteData::${deferredRemoteData}")
        deferredRemoteData.body()?.let { insertTeamStatistics(team, it) }
    }

    private suspend fun insertTeamStatistics(teamId: String, resultApi: ResultApi) =
        coroutineScope {
            resultApi.data.let { lstData ->
                if (lstData != null) {
                    if(teamStatsRepository.getAllByTeamId(teamId).isNullOrEmpty()){
                        for (item in lstData) {
                            val innerTeamStatistics = TeamStatistics(
                                teamId,
                                item.gid,
                                item.seas,
                                item.wk,
                                item.day,
                                item.v,
                                item.h,
                                item.stad,
                                item.temp,
                                item.humd,
                                item.wspd,
                                item.wdir,
                                item.cond,
                                item.surf,
                                item.ou,
                                item.sprv,
                                item.ptsv,
                                item.ptsh
                            )
                            teamStatsRepository.insert(innerTeamStatistics)
                        }
                    }
                }
            }
        }

    private suspend fun getAllStatisticsByTeamId(teamId: String) = coroutineScope {
        listOfTeamStatistics.postValue(teamStatsRepository.getAllByTeamId(teamId))
    }

    override fun onCleared() {
        super.onCleared().also {
            coroutineContext.cancel()
        }
    }
}