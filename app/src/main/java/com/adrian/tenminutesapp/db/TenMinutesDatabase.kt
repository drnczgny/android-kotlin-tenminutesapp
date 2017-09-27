package com.adrian.tenminutesapp.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.adrian.tenminutesapp.pages.tenminutes.repository.dao.SingleCostRegistryDao
import com.adrian.tenminutesapp.pages.tenminutes.repository.entity.SingleCostRegistryEntity

/**
 * Created by cadri on 2017. 09. 27..
 */

@Database(entities = arrayOf(SingleCostRegistryEntity::class), version = 3)
abstract class TenMinutesDatabase : RoomDatabase() {

    abstract fun singleCostRegistryEntityDao(): SingleCostRegistryDao

}