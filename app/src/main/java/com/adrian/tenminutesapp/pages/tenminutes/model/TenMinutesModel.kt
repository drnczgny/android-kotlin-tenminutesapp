package com.adrian.tenminutesapp.pages.tenminutes.model

import com.adrian.tenminutesapp.pages.tenminutes.dto.SingleCostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.dto.CostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.dto.FoodType
import com.adrian.tenminutesapp.pages.tenminutes.subpages.history.dto.History
import org.threeten.bp.LocalDate

/**
 * Created by cadri on 2017. 09. 23..
 */

class TenMinutesModel {

    object logging {
        val TAG = TenMinutesModel::class.java.simpleName
    }

    var historyList: MutableList<History> = ArrayList()

    init {
        historyList = testHistory()
    }

    fun addHistory(history: History) {
        historyList.add(0, history)
    }

    private fun testHistory(): MutableList<History> {
        val costRegistry1 = CostRegistry(listOf<SingleCostRegistry>(
                SingleCostRegistry(FoodType.DEFAULT, 1000, LocalDate.now()),
                SingleCostRegistry(FoodType.DEFAULT, 2000, LocalDate.now()),
                SingleCostRegistry(FoodType.DEFAULT, 3000, LocalDate.now())) as MutableList<SingleCostRegistry>)
        val costRegistry2 = CostRegistry(listOf<SingleCostRegistry>(
                SingleCostRegistry(FoodType.DEFAULT, 1500, LocalDate.now()),
                SingleCostRegistry(FoodType.DEFAULT, 2500, LocalDate.now()),
                SingleCostRegistry(FoodType.DEFAULT, 3500, LocalDate.now())) as MutableList<SingleCostRegistry>)
        return mutableListOf(History(costRegistry1), History(costRegistry2))
    }
}