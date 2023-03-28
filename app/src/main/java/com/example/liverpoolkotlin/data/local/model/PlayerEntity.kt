package com.example.liverpoolkotlin.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player_table")
class PlayerEntity (
    @PrimaryKey(autoGenerate = false)
    val playerId: Int,
    val name: String,
    val position: String,
    val imageUrl: String
        )