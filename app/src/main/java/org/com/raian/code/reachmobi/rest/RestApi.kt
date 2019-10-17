package org.com.raian.code.reachmobi.rest

import org.com.raian.code.reachmobi.rest.model.ResultApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RestApi {

    @GET("test/games/{team}")
    fun getResultsByTeam(@Path("team") team: String): Call<ResultApi>
}