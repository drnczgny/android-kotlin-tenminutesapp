package com.adrian.tenminutesapp.di

import com.adrian.tenminutesapp.pages.home.di.HomePageModule
import com.adrian.tenminutesapp.pages.home.view.HomePageActivity
import com.adrian.tenminutesapp.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by cadri on 2017. 08. 03..
 */

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(HomePageModule::class))
    abstract fun bindHomePageActivity(): HomePageActivity
}