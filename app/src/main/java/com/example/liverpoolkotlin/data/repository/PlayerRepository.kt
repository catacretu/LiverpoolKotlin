package com.example.liverpoolkotlin.data.repository

import com.example.liverpoolkotlin.data.local.model.PlayerEntity
import io.reactivex.rxjava3.core.Single

interface PlayerRepository {
    fun getPlayers(): Single<List<PlayerEntity>>
}