package com.adrian.tenminutesapp.pages.tenminutes.repository.converter

import com.adrian.tenminutesapp.pages.tenminutes.dto.FoodType
import com.adrian.tenminutesapp.pages.tenminutes.dto.SingleCostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.repository.entity.SingleCostRegistryEntity
import org.threeten.bp.LocalDateTime

/**
 * Created by cadri on 2017. 09. 27..
 */

fun convertSingleCostRegistryToSingleCostRegistryEntity(singleCostRegistry: SingleCostRegistry): SingleCostRegistryEntity {
    return SingleCostRegistryEntity(0, singleCostRegistry.foodType.toString(), singleCostRegistry.price, singleCostRegistry.dateTime.toString())
}

fun convertSingleCostRegistryEntityToSingleCostRegistry(singleCostRegistryEntity: SingleCostRegistryEntity): SingleCostRegistry {
    return SingleCostRegistry(FoodType.DEFAULT, singleCostRegistryEntity.price, LocalDateTime.parse(singleCostRegistryEntity.dateTime))
}