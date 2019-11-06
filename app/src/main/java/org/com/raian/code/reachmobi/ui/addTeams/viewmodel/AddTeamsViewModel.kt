package org.com.raian.code.reachmobi.ui.addTeams.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import org.com.raian.code.reachmobi.constants.GlobalConstants
import org.com.raian.code.reachmobi.dagger.components.DaggerRepositoryInjector
import org.com.raian.code.reachmobi.dagger.modules.TeamsRepositoryModule
import org.com.raian.code.reachmobi.model.database.model.TeamDataClass
import org.com.raian.code.reachmobi.model.repository.TeamsRepository
import org.com.raian.code.reachmobi.ui.base.BaseViewModel
import java.util.logging.Logger
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 * Concurrency in Coroutines: https://proandroiddev.com/kotlin-coroutines-handling-concurrency-like-a-pro-retrofit2-coroutines-31cd0611fd91
 * */

class AddTeamsViewModel : BaseViewModel() {
    override val coroutineContext: CoroutineContext
        get() = Job()

    private val injector = DaggerRepositoryInjector.builder()
        .repositoryModule(TeamsRepositoryModule())
        .build()

    @Inject
    lateinit var repository: TeamsRepository

    private val listOfTeams by lazy {
        MutableLiveData<List<TeamDataClass>>()
    }

    fun getListOfTeamsUI(): LiveData<List<TeamDataClass>> {
        return listOfTeams
    }

    init {
        TAG = AddTeamsViewModel::class.java.simpleName
        logger = Logger.getLogger(TAG)
        inject()
    }

    private fun inject() {
        injector.inject(this)
    }

    fun checkLocalData() = launch(Dispatchers.IO) {
        val lstRes = repository.getAll()
        if (lstRes.isNullOrEmpty()) {
            for ((key, value) in GlobalConstants.mapOfTeams) {
                val innerTeam = TeamDataClass(key, false, value)
                repository.insert(innerTeam)
            }
            listOfTeams.postValue(repository.getAll())
        } else {
            listOfTeams.postValue(lstRes)
        }
    }

    fun saveTeam(item: TeamDataClass) = launch(Dispatchers.IO) {
        repository.update(item)
    }

    override fun onCleared() {
        super.onCleared().also {
            coroutineContext.cancel()
        }
    }

}