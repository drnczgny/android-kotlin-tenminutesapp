package com.adrian.tenminutesapp.pages.tenminutes.subpages.home.dto

/**
 * Created by cadri on 2017. 09. 26..
 */

data class OrderSummaryDto constructor(val balance: Long, val typedCost: Long, val menuACount: Int,
                                       val menuBCount: Int, val flavoredDressingCount: Int) {}