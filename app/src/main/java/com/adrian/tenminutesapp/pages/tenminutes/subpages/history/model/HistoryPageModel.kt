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

    fun findHistory() : List<CostRegistry> {
        return listOf(
                CostRegistry(mutableListOf<SingleCostRegistry>(
                        SingleCostRegistry(FoodType.DEFAULT, 1000, LocalDate.now()),
                        SingleCostRegistry(FoodType.DEFAULT, 2000, LocalDate.now()),
                        SingleCostRegistry(FoodType.DEFAULT, 3000, LocalDate.now())
                ))
        )
    }
}