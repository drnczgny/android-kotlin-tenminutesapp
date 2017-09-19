package com.adrian.tenminutesapp.di

import com.adrian.tenminutesapp.MyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by cadri on 2017. 08. 03..
 */

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(myApplication: MyApplication) = myApplication

}