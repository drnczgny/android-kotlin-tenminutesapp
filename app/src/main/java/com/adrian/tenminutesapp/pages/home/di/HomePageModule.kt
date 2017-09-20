package com.adrian.tenminutesapp.pages.home.di

import android.content.SharedPreferences
import com.adrian.tenminutesapp.pages.home.model.HomePageModel
import com.adrian.tenminutesapp.pages.home.service.HomePageService
import com.adrian.tenminutesapp.pages.home.view.HomePageActivity
import com.adrian.tenminutesapp.pages.home.view.HomePageRouter
import com.adrian.tenminutesapp.pages.home.viewmodel.HomePageViewModel
import com.adrian.tenminutesapp.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by cadri on 2017. 09. 19..
 */

@Module
class HomePageModule {

    @ActivityScope
    @Provides
    fun providesHomePageRouter(homePageActivity: HomePageActivity): HomePageRouter = homePageActivity

    @ActivityScope
    @Provides
    fun providesHomePageService() = HomePageService()

    @ActivityScope
    @Provides
    fun providesHomePageModel(homePageService: HomePageService, sharedPreferences: SharedPreferences)
            = HomePageModel(homePageService, sharedPreferences)

    @ActivityScope
    @Provides
    fun providesHomePageViewModel(homePageRouter: HomePageRouter, homePageModel: HomePageModel)
            = HomePageViewModel(homePageRouter, homePageModel)
}