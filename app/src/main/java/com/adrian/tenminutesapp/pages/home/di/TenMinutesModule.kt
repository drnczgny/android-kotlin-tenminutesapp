package com.adrian.tenminutesapp.pages.home.di

import com.adrian.tenminutesapp.pages.home.view.TenMinutesActivity
import com.adrian.tenminutesapp.pages.home.view.TenMinutesRouter
import com.adrian.tenminutesapp.pages.home.viewmodel.TenMinutesViewModel
import com.adrian.tenminutesapp.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by cadri on 2017. 09. 19..
 */

@Module
class TenMinutesModule {

    @ActivityScope
    @Provides
    fun providesTenMinutesRouter(tenMinutesActivity: TenMinutesActivity): TenMinutesRouter = tenMinutesActivity

    @ActivityScope
    @Provides
    fun providesTenMinutesViewModel(tenMinutesRouter: TenMinutesRouter)
            = TenMinutesViewModel(tenMinutesRouter)
}