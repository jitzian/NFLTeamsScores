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
import org.com.raian.code.reachmobi.ui.model.TeamDataUI
import org.com.raian.code.reachmobi.ui.model.TeamDetails
import retrofit2.Retrofit
import java.util.logging.Logger
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ShowTeamsViewModel : BaseViewModel() {
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

    private var listOfStatistics = ArrayList<TeamStatistics>()

    private var listOfTeamData = ArrayList<TeamDetails>()

    /*********************************************************************************/
    private var listOfTeamDetails = ArrayList<TeamDetails>()
    private var listOfTeamsData = ArrayList<TeamDataUI>()

    private val teamData by lazy {
        MutableLiveData<List<TeamDataUI>>()
    }
    val teamDataUI: LiveData<List<TeamDataUI>>
        get() = teamData
    /*********************************************************************************/

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
                listOfStatistics.clear()
                listOfTeamData.clear()
                listOfTeamsData.clear()
                listOfTeamDetails.clear()
                for (item in selectedTeams) {
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
        deferredRemoteData.body()?.let { insertTeamStatistics(team, it) }
    }

    private suspend fun insertTeamStatistics(teamId: String, resultApi: ResultApi) =
        coroutineScope {
            resultApi.data.let { lstData ->
                if (lstData != null) {
                    if (teamStatsRepository.getAllByTeamId(teamId).isNullOrEmpty()) {
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
        for (item in teamStatsRepository.getAllByTeamId(teamId)) {
            val innerTeamDetails = TeamDetails(
                item.gid,
                item.seas,
                item.wk,
                item.day,
                item.v,
                item.h,
                item.stad
            )
            listOfStatistics.add(item)
            listOfTeamDetails.add(innerTeamDetails)
        }
        listOfTeamsData.add(TeamDataUI(teamId, listOfTeamDetails))
        teamData.postValue(listOfTeamsData)
    }

    fun clearDataAndSelection(teamName: String) = launch(Dispatchers.IO) {
        val team = teamsRepository.getById(teamName)
        team.isSelected = false
        teamsRepository.update(team)
        teamStatsRepository.deleteByTeamId(teamName)
    }

    override fun onCleared() {
        super.onCleared().also {
            coroutineContext.cancel()
        }
    }
}