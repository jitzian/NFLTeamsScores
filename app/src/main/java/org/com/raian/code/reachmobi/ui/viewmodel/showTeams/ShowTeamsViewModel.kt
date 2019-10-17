package org.com.raian.code.reachmobi.ui.viewmodel.showTeams

import dagger.Lazy
import kotlinx.coroutines.*
import org.com.raian.code.reachmobi.dagger.components.DaggerComponentInjector
import org.com.raian.code.reachmobi.dagger.modules.NetworkModule
import org.com.raian.code.reachmobi.rest.RestApi
import org.com.raian.code.reachmobi.rest.model.ResultApi
import org.com.raian.code.reachmobi.ui.base.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.util.logging.Logger
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ShowTeamsViewModel : BaseViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Job()

    private val injector = DaggerComponentInjector.builder()
        .networkModule(NetworkModule())
        .build()

    @Inject
    lateinit var retrofit: Lazy<Retrofit>

    init {
        TAG = ShowTeamsViewModel::class.java.simpleName
        logger = Logger.getLogger(TAG)
        inject()
    }

    private fun inject(){
        injector.inject(this)
        restApi = retrofit.get().create(RestApi::class.java)
    }

    fun getResultsByTeam(team: String) = launch {
        val deferredResultByTeam = async {
            restApi.getResultsByTeam(team).enqueue(object: Callback<ResultApi>{
                override fun onFailure(call: Call<ResultApi>, t: Throwable) {
                    logger.severe("$TAG::getResultsByTeam::onFailure::${t.message}")
                }

                override fun onResponse(call: Call<ResultApi>, response: Response<ResultApi>) {
                    logger.severe("$TAG::getResultsByTeam::onResponse::${response.body()}")
                }

            })
        }
        deferredResultByTeam.await()
    }

    override fun onCleared() {
        super.onCleared().also {
            coroutineContext.cancel()
        }
    }

}