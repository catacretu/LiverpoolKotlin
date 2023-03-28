package com.example.liverpoolkotlin.data.remote

import com.example.liverpoolkotlin.data.local.model.PlayerEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface PlayerAPI {

    @GET("/catacretu/Project/master/Data1")
    fun getPlayers(): Single<List<PlayerResponse>>

}