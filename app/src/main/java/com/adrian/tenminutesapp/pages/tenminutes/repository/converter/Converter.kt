package com.adrian.tenminutesapp.pages.tenminutes.repository.converter

import com.adrian.tenminutesapp.pages.tenminutes.dto.CostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.dto.FoodType
import com.adrian.tenminutesapp.pages.tenminutes.dto.SingleCostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.repository.entity.CostRegistryEntity
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

fun convertCostRegistryToCostRegistryEntity(costRegistry: CostRegistry): CostRegistryEntity {
    var costRegistryEntity: CostRegistryEntity = CostRegistryEntity()
    var entities: MutableList<SingleCostRegistryEntity> = ArrayList()
    for (singleCostRegistry in costRegistry.singleCostRegistries) {
        entities.add(convertSingleCostRegistryToSingleCostRegistryEntity(singleCostRegistry))
    }
    costRegistryEntity.singleCostRegistryEntities = entities
    return costRegistryEntity
}

fun convertCostRegistryEntityToCostRegistry(costRegistryEntity: CostRegistryEntity): CostRegistry {
    var costRegistry: CostRegistry = CostRegistry()
    var items: MutableList<SingleCostRegistry> = ArrayList()
    for (singleCostRegistryEntity in costRegistryEntity.singleCostRegistryEntities) {
        items.add(convertSingleCostRegistryEntityToSingleCostRegistry(singleCostRegistryEntity))
    }
    costRegistry.singleCostRegistries = items
    return costRegistry
}