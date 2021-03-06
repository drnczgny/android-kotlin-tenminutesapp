package com.adrian.tenminutesapp.di

import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import com.adrian.tenminutesapp.MyApplication
import com.adrian.tenminutesapp.db.TenMinutesDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by cadri on 2017. 08. 03..
 */

@Module
class AppModule {

    @Singleton
    @Provides
    @Named("ApplicationContext")
    fun provideContext(myApplication: MyApplication): Context = myApplication

    @Singleton
    @Provides
    fun provideSharedPreferences(@Named("ApplicationContext") context: Context): SharedPreferences {
        return context.getSharedPreferences("PREFS", Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideTenMinutesDatabase(@Named("ApplicationContext") context: Context): TenMinutesDatabase {
        return Room.databaseBuilder(context, TenMinutesDatabase::class.java, "tenminutes-db").build()
    }
}