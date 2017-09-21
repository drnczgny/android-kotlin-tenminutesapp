package com.adrian.tenminutesapp.pages.home.di

import com.adrian.tenminutesapp.pages.home.view.HomePageFragment
import com.adrian.tenminutesapp.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by cadri on 2017. 09. 21..
 */
@Module
abstract class HomePageActivityFragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = arrayOf(HomePageFragmentModule::class))
    abstract fun bindHomePageFragment(): HomePageFragment

//    @FragmentScope
//    @ContributesAndroidInjector(modules = arrayOf(CostRegistrySummaryPageFragmentModule::class))
//    abstract fun bindCostRegistrySummaryFragment(): CostRegistrySummaryPageFragment


}