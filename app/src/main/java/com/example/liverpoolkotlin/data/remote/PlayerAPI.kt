package com.example.liverpoolkotlin.data.remote

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface PlayerAPI {

    @GET("/catacretu/Project/master/Data")
    fun getPlayers(): Single<List<PlayerResponse>>

}