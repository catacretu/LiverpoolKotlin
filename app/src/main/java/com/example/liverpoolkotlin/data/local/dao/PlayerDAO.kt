package com.example.liverpoolkotlin.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.liverpoolkotlin.data.local.model.PlayerEntity
import io.reactivex.rxjava3.core.Single


@Dao
interface PlayerDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePlayers(playersList: List<PlayerEntity>)

    @Query("SELECT * FROM player_table")
    fun getAllPlayers(): Single<List<PlayerEntity>>
}