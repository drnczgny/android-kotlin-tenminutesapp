package com.adrian.tenminutesapp.pages.tenminutes.di

import com.adrian.tenminutesapp.db.TenMinutesDatabase
import com.adrian.tenminutesapp.pages.tenminutes.model.TenMinutesModel
import com.adrian.tenminutesapp.pages.tenminutes.subpages.home.service.RoomDBTenMinutesService
import com.adrian.tenminutesapp.pages.tenminutes.subpages.home.service.TenMinutesService
import com.adrian.tenminutesapp.pages.tenminutes.view.TenMinutesActivity
import com.adrian.tenminutesapp.pages.tenminutes.view.TenMinutesRouter
import com.adrian.tenminutesapp.pages.tenminutes.viewmodel.TenMinutesViewModel
import com.adrian.tenminutesapp.scope.ActivityScope
import com.adrian.tenminutesapp.utils.viewpager.TenMinutesViewPagerDataModel
import com.adrian.tenminutesapp.utils.viewpager.ViewPagerAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Named

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

    @ActivityScope
    @Provides
    @Named("RoomDBTenMinutesService")
    fun providesHomePageService(database: TenMinutesDatabase): TenMinutesService = RoomDBTenMinutesService(database)

    @ActivityScope
    @Provides
    fun providesTenMinutesModel(@Named("RoomDBTenMinutesService") tenMinutesService: TenMinutesService)
            = TenMinutesModel(tenMinutesService)

    @ActivityScope
    @Provides
    fun provideTenMinutesViewPagerDataModel() = TenMinutesViewPagerDataModel()

    @ActivityScope
    @Provides
    fun provideViewPagerAdapter(tenMinutesActivity: TenMinutesActivity, tenMinutesViewPagerDataModel: TenMinutesViewPagerDataModel): ViewPagerAdapter {
        return ViewPagerAdapter(tenMinutesActivity.supportFragmentManager, tenMinutesViewPagerDataModel)
    }
}