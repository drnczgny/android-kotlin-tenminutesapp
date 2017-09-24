package com.adrian.tenminutesapp.pages.tenminutes.subpages.history.model

import com.adrian.tenminutesapp.pages.tenminutes.dto.CostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.dto.FoodType
import com.adrian.tenminutesapp.pages.tenminutes.dto.SingleCostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.model.TenMinutesModel
import org.threeten.bp.LocalDate

/**
 * Created by cadri on 2017. 09. 23..
 */

class HistoryPageModel constructor(val tenMinutesModel: TenMinutesModel) {

    fun findHistory(): List<CostRegistry> {
        var costRegistry1: CostRegistry = CostRegistry(mutableListOf<SingleCostRegistry>(
                SingleCostRegistry(FoodType.MENU_A, 1000, LocalDate.now()),
                SingleCostRegistry(FoodType.DEFAULT, 2000, LocalDate.now()),
                SingleCostRegistry(FoodType.DEFAULT, 3000, LocalDate.now())
        ))
        var costRegistry2: CostRegistry = CostRegistry(mutableListOf<SingleCostRegistry>(
                SingleCostRegistry(FoodType.MENU_B, 1500, LocalDate.now()),
                SingleCostRegistry(FoodType.DEFAULT, 2500, LocalDate.now())
        ))
        return listOf(costRegistry1, costRegistry2)
    }
}