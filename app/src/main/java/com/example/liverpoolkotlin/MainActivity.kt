package com.example.liverpoolkotlin

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.liverpoolkotlin.viewmodel.PlayerViewModel
import com.example.liverpoolkotlin.views.HistoryScreen
import com.example.liverpoolkotlin.views.HomeScreen
import com.example.liverpoolkotlin.views.LineupScreen
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var playerViewModel: PlayerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            navigationGraph()
        }
    }

    @Composable
    fun navigationGraph() {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "home"
        )
        {
            composable("home") {
                HomeScreen(navController = navController)
            }
            composable("history") {
                HistoryScreen()
            }
            composable("lineup") {
                val playersList = playerViewModel.playerData.value
                LineupScreen(playersList)
            }
        }
    }
}