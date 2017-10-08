package com.adrian.tenminutesapp.pages.tenminutes.subpages.home.model

import android.content.SharedPreferences
import com.adrian.tenminutesapp.pages.tenminutes.dto.CostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.dto.FoodType
import com.adrian.tenminutesapp.pages.tenminutes.dto.SingleCostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.model.TenMinutesModel
import com.adrian.tenminutesapp.pages.tenminutes.subpages.home.dto.OrderSummaryDto
import org.threeten.bp.LocalDateTime

/**
 * Created by cadri on 2017. 09. 19..
 */

class HomePageModel constructor(
        val tenMinutesModel: TenMinutesModel,
        val sharedPreferences: SharedPreferences) {

    var singleCostRegistryList: MutableList<SingleCostRegistry> = ArrayList()

    fun findBalance(): String = sharedPreferences.getString("BALANCE", "")

    fun saveCostRegistry(orderSummaryDto: OrderSummaryDto) {
        refreshSingleCostRegistryList(orderSummaryDto)
        tenMinutesModel.addCostRegistry(CostRegistry(singleCostRegistryList.toList()))
    }

    fun updateBalance(balance: Long) {
        saveBalance(balance.toString())
    }

    fun calculateCurrentCost(orderSummaryDto: OrderSummaryDto): Long {
        var result: Long = 0
        result += orderSummaryDto.typedCost
        result += orderSummaryDto.menuACount * FoodType.MENU_A.price.toLong()
        result += orderSummaryDto.menuBCount * FoodType.MENU_B.price.toLong()
        result += orderSummaryDto.flavoredDressingCount * FoodType.FLAVORED_DRESSING.price.toLong()
        return result
    }

    fun saveSingleCostRegistry(singleCostRegistry: SingleCostRegistry) {
        tenMinutesModel.saveSingleCostRegistry(singleCostRegistry)
    }

    fun findAllSingleCostRegistry() {
        tenMinutesModel.findAllSingleCostRegistry()
    }

    private fun saveBalance(balance: String) {
        val editor = sharedPreferences.edit()
        editor.putString("BALANCE", balance)
        editor.commit()
    }

    private fun refreshSingleCostRegistryList(orderSummaryDto: OrderSummaryDto) {
        singleCostRegistryList.clear()
        if (orderSummaryDto.typedCost > 0)
            singleCostRegistryList.add(SingleCostRegistry(FoodType.DEFAULT, orderSummaryDto.typedCost, LocalDateTime.now()))
        for (i in 1..orderSummaryDto.menuACount)
            singleCostRegistryList.add(SingleCostRegistry(FoodType.MENU_A, FoodType.MENU_A.price, LocalDateTime.now()))
        for (i in 1..orderSummaryDto.menuBCount)
            singleCostRegistryList.add(SingleCostRegistry(FoodType.MENU_B, FoodType.MENU_B.price, LocalDateTime.now()))
        for (i in 1..orderSummaryDto.flavoredDressingCount)
            singleCostRegistryList.add(SingleCostRegistry(FoodType.FLAVORED_DRESSING, FoodType.FLAVORED_DRESSING.price, LocalDateTime.now()))
    }
}