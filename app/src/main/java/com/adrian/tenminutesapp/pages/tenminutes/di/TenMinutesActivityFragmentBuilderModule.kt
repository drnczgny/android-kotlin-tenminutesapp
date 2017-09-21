package com.adrian.tenminutesapp.pages.tenminutes.di

import com.adrian.tenminutesapp.pages.tenminutes.subpages.home.di.HomePageModule
import com.adrian.tenminutesapp.pages.tenminutes.subpages.home.view.HomePageFragment
import com.adrian.tenminutesapp.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by cadri on 2017. 09. 21..
 */
@Module
abstract class TenMinutesActivityFragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = arrayOf(HomePageModule::class))
    abstract fun bindHomePageFragment(): HomePageFragment

//    @FragmentScope
//    @ContributesAndroidInjector(modules = arrayOf(CostRegistrySummaryPageFragmentModule::class))
//    abstract fun bindCostRegistrySummaryFragment(): CostRegistrySummaryPageFragment


}