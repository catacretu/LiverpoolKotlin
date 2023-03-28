package com.example.liverpoolkotlin.di

import android.app.Application
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        AppModule::class,
        ActivitiesModule::class,
        FragmentModules::class
    ]
)

@Singleton
interface AppComponent {
    fun inject(application: Application)
}