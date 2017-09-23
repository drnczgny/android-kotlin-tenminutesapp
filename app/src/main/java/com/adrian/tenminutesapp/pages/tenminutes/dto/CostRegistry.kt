package com.adrian.tenminutesapp.pages.tenminutes.dto

/**
 * Created by cadri on 2017. 09. 19..
 */

data class CostRegistry(val singleCostRegistries: MutableList<SingleCostRegistry>) {

    fun add(singleCostRegistry: SingleCostRegistry) {
        singleCostRegistries.add(singleCostRegistry)
    }

    fun remove(id: Int) {
        singleCostRegistries.removeAt(id)
    }
}