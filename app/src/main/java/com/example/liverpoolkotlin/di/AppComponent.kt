package com.example.liverpoolkotlin.di

import com.example.liverpoolkotlin.LiverpoolApp
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivitiesModule::class,
    ]
)

@Singleton
interface AppComponent {
    fun inject(application: LiverpoolApp)
}