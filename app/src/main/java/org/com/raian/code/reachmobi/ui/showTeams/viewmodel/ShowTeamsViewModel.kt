package org.com.raian.code.reachmobi.ui.showTeams.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.Lazy
import kotlinx.coroutines.*
import org.com.raian.code.reachmobi.dagger.components.DaggerComponentInjector
import org.com.raian.code.reachmobi.dagger.modules.NetworkModule
import org.com.raian.code.reachmobi.dagger.modules.RepositoryModule
import org.com.raian.code.reachmobi.model.database.model.TeamDataClass
import org.com.raian.code.reachmobi.model.repository.TeamsRepository
import org.com.raian.code.reachmobi.rest.RestApi
import org.com.raian.code.reachmobi.rest.model.ResultApi
import org.com.raian.code.reachmobi.ui.base.BaseViewModel
import org.com.raian.code.reachmobi.utility.safeLet
import retrofit2.Retrofit
import java.util.logging.Logger
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ShowTeamsViewModel : BaseViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Job()

    private val injector = DaggerComponentInjector.builder()
        .networkModule(NetworkModule())
        .repositoryModule(RepositoryModule())
        .build()

    @Inject
    lateinit var retrofit: Lazy<Retrofit>

    @Inject
    lateinit var repository: TeamsRepository

    private val listOfTeams by lazy {
        MutableLiveData<List<TeamDataClass>>()
    }

    fun getListOfTeamsUI(): LiveData<List<TeamDataClass>> {
        return listOfTeams
    }

    private var listOfRemoteResults = ArrayList<ResultApi>()

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
        launch(Dispatchers.IO) {

            getLocalData().let { listRes ->
                listOfTeams.postValue(listRes)
                for (i in listRes) {
                    logger.severe("$TAG::$i")
                    i.teamName?.let { item ->
                        getRemoteData(item)
                    }
                }
                logger.severe("$TAG::AFTER-->> $listOfRemoteResults")
            }
        }
    }

    private suspend fun getLocalData(): List<TeamDataClass> = coroutineScope {
        return@coroutineScope repository.db.get().teamDao().getAllByStatus(true)
    }


    private suspend fun getRemoteData(team: String) = coroutineScope {
        withContext(Dispatchers.Default) {
            restApi.getResultsByTeam(team).execute().body()?.let {
                listOfRemoteResults.add(it)
            }
        }
    }

    /**********************************************************************************************
     * Brandon
     * *******************************************************************************************/
    fun getSelectedTeamStats() {
        logger.severe("$TAG::getSelectedTeamStats")
        launch(Dispatchers.IO) {
            retrieveLocalData()
            listOfTeams.value?.let {
                fetchRemoteData(it)
            }
        }
    }

    private suspend fun retrieveLocalData() = coroutineScope {
        val teams = repository.db.get().teamDao().getAllByStatus(true)
        withContext(Dispatchers.Main) {
            listOfTeams.value = teams
        }
    }

    private suspend fun fetchRemoteData(teams: List<TeamDataClass>) = coroutineScope {
        for (team in teams) {
            val teamName = team.teamName ?: continue
            fetchTeamRemoteData(teamName)
        }
    }

    private fun CoroutineScope.fetchTeamRemoteData(teamName: String) = launch {
        val teamData: ResultApi? = restApi.getResultsByTeam(teamName).execute().body()
        logger.severe(
            if (teamData == null) {
                "Nothing came back for a team named $teamName"
            } else {
                "Team Data for team name $teamName $teamData"
            }
        )
    }

    override fun onCleared() {
        super.onCleared().also {
            coroutineContext.cancel()
        }
    }

}