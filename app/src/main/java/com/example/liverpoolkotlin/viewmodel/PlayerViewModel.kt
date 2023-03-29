package com.example.liverpoolkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.liverpoolkotlin.data.local.model.PlayerEntity
import com.example.liverpoolkotlin.data.repository.PlayerRepository
import javax.inject.Inject

class PlayerViewModel @Inject constructor(private val repository: PlayerRepository) : ViewModel() {

    private var playerData: MutableLiveData<List<PlayerEntity>> = MutableLiveData()


    init {
        loadPlayerData()
    }

    fun getPlayerObserver(): MutableLiveData<List<PlayerEntity>> {
        return playerData
    }

    private fun loadPlayerData() {
        val list = repository.getPlayers().blockingGet()
        playerData.postValue(list)
    }

}