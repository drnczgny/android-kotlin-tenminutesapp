package com.adrian.tenminutesapp.pages.tenminutes.model

import com.adrian.tenminutesapp.pages.tenminutes.dto.CostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.dto.FoodType
import com.adrian.tenminutesapp.pages.tenminutes.dto.SingleCostRegistry
import org.threeten.bp.LocalDate

/**
 * Created by cadri on 2017. 09. 23..
 */

class TenMinutesModel {

    object logging {
        val TAG = TenMinutesModel::class.java.simpleName
    }

    var costRegistryList: MutableList<CostRegistry> = ArrayList()

    init {
        costRegistryList = testHistory()
    }

    fun addCostRegistry(costRegistry: CostRegistry) {
        costRegistryList.add(0, costRegistry)
    }

    private fun testHistory(): MutableList<CostRegistry> {
        val costRegistry1 = CostRegistry(listOf<SingleCostRegistry>(
                SingleCostRegistry(FoodType.DEFAULT, 1000, LocalDate.now()),
                SingleCostRegistry(FoodType.DEFAULT, 2000, LocalDate.now()),
                SingleCostRegistry(FoodType.DEFAULT, 3000, LocalDate.now())) as MutableList<SingleCostRegistry>)
        val costRegistry2 = CostRegistry(listOf<SingleCostRegistry>(
                SingleCostRegistry(FoodType.DEFAULT, 1500, LocalDate.now()),
                SingleCostRegistry(FoodType.DEFAULT, 2500, LocalDate.now()),
                SingleCostRegistry(FoodType.DEFAULT, 3500, LocalDate.now())) as MutableList<SingleCostRegistry>)
        return mutableListOf(costRegistry1, costRegistry2)
    }
}