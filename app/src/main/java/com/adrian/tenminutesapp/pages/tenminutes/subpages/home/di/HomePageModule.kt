package com.adrian.tenminutesapp.pages.tenminutes.subpages.home.di

import android.content.SharedPreferences
import com.adrian.tenminutesapp.pages.tenminutes.subpages.home.service.HomePageService
import com.adrian.tenminutesapp.pages.tenminutes.subpages.home.model.HomePageModel
import com.adrian.tenminutesapp.pages.tenminutes.subpages.home.view.HomePageFragment
import com.adrian.tenminutesapp.pages.tenminutes.subpages.home.view.HomePageRouter
import com.adrian.tenminutesapp.pages.tenminutes.subpages.home.viewmodel.HomePageViewModel
import com.adrian.tenminutesapp.scope.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * Created by cadri on 2017. 09. 21..
 */

@Module
class HomePageModule {

    @FragmentScope
    @Provides
    fun providesHomePageRouter(homePageFragment: HomePageFragment): HomePageRouter = homePageFragment

    @FragmentScope
    @Provides
    fun providesHomePageService() = HomePageService()

    @FragmentScope
    @Provides
    fun providesHomePageModel(homePageService: HomePageService, sharedPreferences: SharedPreferences)
            = HomePageModel(homePageService, sharedPreferences)

    @FragmentScope
    @Provides
    fun providesHomePageViewModel(homePageModel: HomePageModel) = HomePageViewModel(homePageModel)
}