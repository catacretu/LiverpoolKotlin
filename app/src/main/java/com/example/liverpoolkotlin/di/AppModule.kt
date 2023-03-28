package com.example.liverpoolkotlin.di

import android.content.Context
import com.example.liverpoolkotlin.data.database.AppDatabase
import com.example.liverpoolkotlin.data.local.dao.PlayerDAO
import com.example.liverpoolkotlin.data.remote.PlayerAPI
import com.example.liverpoolkotlin.data.remote.RemoteDataSource
import com.example.liverpoolkotlin.data.repository.PlayerRepository
import com.example.liverpoolkotlin.data.repository.PlayerRepositoryImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideContext() = context

    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase {
        return AppDatabase.getAppDatabase(context)
    }

    @Singleton
    @Provides
    fun providePlayerDAO(appDatabase: AppDatabase): PlayerDAO {
        return appDatabase.getPlayerDAO()
    }

    @Singleton
    @Provides
    fun provideGson() = Gson()

    @Singleton
    @Provides
    fun providePlayerAPI(remoteDataSource: RemoteDataSource): PlayerAPI{
        return remoteDataSource.buildApi(PlayerAPI::class.java)
    }

    @Singleton
    @Provides
    fun providePlayerRepository(playerAPI: PlayerAPI, playerDAO: PlayerDAO): PlayerRepository {
        return PlayerRepositoryImpl(playerAPI,playerDAO)
    }
}