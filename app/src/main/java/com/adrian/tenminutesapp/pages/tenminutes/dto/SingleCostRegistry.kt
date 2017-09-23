package com.adrian.tenminutesapp.pages.tenminutes.dto

import org.threeten.bp.LocalDate

/**
 * Created by cadri on 2017. 09. 19..
 */

data class SingleCostRegistry(val foodType: FoodType, val price: Long, val dateTime: LocalDate)

