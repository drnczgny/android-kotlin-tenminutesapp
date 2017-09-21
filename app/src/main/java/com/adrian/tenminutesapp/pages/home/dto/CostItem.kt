package com.adrian.tenminutesapp.pages.home.dto

import org.threeten.bp.LocalDate

/**
 * Created by cadri on 2017. 09. 19..
 */

data class CostItem(val foodType: FoodType, val price: Long, val dateTime: LocalDate)

