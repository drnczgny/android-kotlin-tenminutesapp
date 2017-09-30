package com.adrian.tenminutesapp.pages.tenminutes.subpages.home.service

import com.adrian.tenminutesapp.pages.tenminutes.dto.SingleCostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.repository.entity.SingleCostRegistryEntity
import rx.Single

/**
 * Created by cadri on 2017. 09. 19..
 */

interface TenMinutesService {

    fun findAllSingleCostRegistry(): Single<List<SingleCostRegistryEntity>>

    fun findSingleCostRegistry(singleCostRegistry: SingleCostRegistry)

    fun findSingleCostRegistryById(id: Long)

    fun saveSingleCostRegistry(singleCostRegistry: SingleCostRegistry): Single<Unit>

    fun saveSingleCostRegistries(singleCostRegistries: List<SingleCostRegistry>)

    fun deleteSingleCostRegistry(singleCostRegistry: SingleCostRegistry)

    fun deleteSingleCostRegistryById(id: Long)

    fun insertSingleCostRegistry(singleCostRegistry: SingleCostRegistry)

    fun updateSingleCostRegistry(singleCostRegistry: SingleCostRegistry)

}