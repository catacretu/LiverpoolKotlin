package com.example.liverpoolkotlin.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.liverpoolkotlin.data.local.model.PlayerEntity
import com.example.liverpoolkotlin.data.repository.PlayerRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlayerViewModel @Inject constructor(private val repository: PlayerRepository) : ViewModel() {

    //Inspired from https://stackoverflow.com/questions/69477628/trying-to-get-viewmodel-in-composable
    val playerData: MutableState<List<PlayerEntity>> = mutableStateOf(emptyList())


    init {
        viewModelScope.launch {
            val data = fetchPlayerData()
            playerData.value = data
        }
    }

    suspend fun fetchPlayerData(): List<PlayerEntity> {
        return repository.getPlayers().blockingGet()
    }

}