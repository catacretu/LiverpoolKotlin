package com.example.liverpoolkotlin.data.repository

import com.example.liverpoolkotlin.data.local.dao.PlayerDAO
import com.example.liverpoolkotlin.data.local.model.PlayerEntity
import com.example.liverpoolkotlin.data.remote.PlayerAPI
import com.example.liverpoolkotlin.data.remote.toPlayerEntity
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class PlayerRepositoryImpl @Inject constructor(
    private val playerAPI: PlayerAPI,
    private val playerDAO: PlayerDAO
) : PlayerRepository {

    override fun getPlayers(): Single<List<PlayerEntity>> {
        return playerAPI.getPlayers().subscribeOn(Schedulers.io())
            .map { playersResponseList ->
                playersResponseList
                    .map{playersResponseItem->playersResponseItem.toPlayerEntity()}
            }
            .observeOn(Schedulers.io())
            .doOnSuccess { playerDAO.savePlayers(it)}
            .onErrorResumeNext { playerDAO.getAllPlayers() }

    }
}