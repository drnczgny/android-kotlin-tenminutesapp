package com.adrian.tenminutesapp.pages.tenminutes.repository.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.adrian.tenminutesapp.pages.tenminutes.repository.entity.SingleCostRegistryEntity



/**
 * Created by cadri on 2017. 09. 27..
 */

@Dao
interface SingleCostRegistryDao {

    @Query("SELECT * FROM SingleCostRegistry")
    fun findAll(): List<SingleCostRegistryEntity>

    @Query("SELECT * FROM SingleCostRegistry WHERE id LIKE :id LIMIT 1")
    fun findById(id: Long): SingleCostRegistryEntity

    @Insert(onConflict = REPLACE)
    fun insert(singleCostRegistryEntity: SingleCostRegistryEntity)

    @Update
    fun update(singleCostRegistryEntity: SingleCostRegistryEntity)

}