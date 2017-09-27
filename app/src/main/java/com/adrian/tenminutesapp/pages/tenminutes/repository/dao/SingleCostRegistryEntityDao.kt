package com.adrian.tenminutesapp.pages.tenminutes.repository.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.adrian.tenminutesapp.pages.tenminutes.repository.entity.SingleCostRegistryEntity

/**
 * Created by cadri on 2017. 09. 27..
 */

@Dao
interface SingleCostRegistryEntityDao {

    @Query("SELECT * FROM SingleCostRegistryEntity")
    fun findAll(): List<SingleCostRegistryEntity>

    @Insert
    fun insert(singleCostRegistryEntity: SingleCostRegistryEntity)
}