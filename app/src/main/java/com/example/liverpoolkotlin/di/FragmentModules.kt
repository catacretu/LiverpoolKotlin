package com.example.liverpoolkotlin.di

import com.example.liverpoolkotlin.views.HistoryFragment
import com.example.liverpoolkotlin.views.HomeFragment
import com.example.liverpoolkotlin.views.TeamFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModules {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributeHistoryFragment(): HistoryFragment

    @ContributesAndroidInjector
    abstract fun contributeTeamFragment(): TeamFragment
}