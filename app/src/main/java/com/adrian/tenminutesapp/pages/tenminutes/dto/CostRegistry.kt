package com.adrian.tenminutesapp.pages.tenminutes.dto

/**
 * Created by cadri on 2017. 09. 19..
 */

data class CostRegistry(var singleCostRegistries: List<SingleCostRegistry>) {
    constructor() : this(emptyList())
}