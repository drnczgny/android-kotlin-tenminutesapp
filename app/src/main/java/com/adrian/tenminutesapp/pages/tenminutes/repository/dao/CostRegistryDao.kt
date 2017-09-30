package com.adrian.tenminutesapp.pages.tenminutes.repository.dao

import android.arch.persistence.room.*
import com.adrian.tenminutesapp.pages.tenminutes.repository.entity.CostRegistryEntity

/**
 * Created by cadri on 2017. 09. 30..
 */

@Dao
interface CostRegistryDao {

    @Query("SELECT * FROM CostRegistry")
    fun findAll(): List<CostRegistryEntity>

    @Query("SELECT * FROM CostRegistry WHERE id LIKE :id LIMIT 1")
    fun findById(id: Long): CostRegistryEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(costRegistryEntity: CostRegistryEntity)

    @Update
    fun update(costRegistryEntity: CostRegistryEntity)
}