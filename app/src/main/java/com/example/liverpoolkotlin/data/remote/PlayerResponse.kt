package com.example.liverpoolkotlin.data.remote

import com.example.liverpoolkotlin.data.local.model.PlayerEntity

data class PlayerResponse (
    val id: Int, val name: String, val position: String, val imageUrl:String
    )

fun PlayerResponse.toPlayerEntity() = PlayerEntity(
    playerId = id,
    name = name,
    position = position,
    imageUrl = imageUrl
)