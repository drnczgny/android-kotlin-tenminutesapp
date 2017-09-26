package com.adrian.tenminutesapp.pages.tenminutes.subpages.home.model

import android.content.SharedPreferences
import com.adrian.tenminutesapp.pages.tenminutes.dto.CostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.dto.FoodType
import com.adrian.tenminutesapp.pages.tenminutes.dto.SingleCostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.model.TenMinutesModel
import com.adrian.tenminutesapp.pages.tenminutes.subpages.home.dto.OrderSummaryDto
import com.adrian.tenminutesapp.pages.tenminutes.subpages.home.service.HomePageService
import org.threeten.bp.LocalDateTime


/**
 * Created by cadri on 2017. 09. 19..
 */

class HomePageModel constructor(val tenMinutesModel: TenMinutesModel, val homePageService: HomePageService, val sharedPreferences: SharedPreferences) {

    var singleCostRegistryList: MutableList<SingleCostRegistry> = ArrayList()

    fun addMenuAItem() {
        singleCostRegistryList.add(SingleCostRegistry(FoodType.MENU_A, 900, LocalDateTime.now()))
    }

    fun addMenuBItem() {
        singleCostRegistryList.add(SingleCostRegistry(FoodType.MENU_B, 1090, LocalDateTime.now()))
    }

    fun addFlavoredDressingItem() {
        singleCostRegistryList.add(SingleCostRegistry(FoodType.FLAVORED_DRESSING, 100, LocalDateTime.now()))
    }

    fun removeMenuAItem() {
//        removeByType(FoodType.MENU_A)
        singleCostRegistryList.removeAt(0)
    }

    fun removeMenuBItem() {
//        removeByType(FoodType.MENU_B)
        singleCostRegistryList.removeAt(0)
    }

    fun removeFlavoredDressingItem() {
//        removeByType(FoodType.FLAVORED_DRESSING)
        singleCostRegistryList.removeAt(0)
    }

    fun addItem(price: Long) {
        singleCostRegistryList.add(SingleCostRegistry(FoodType.DEFAULT, price, LocalDateTime.now()))
    }

    fun removeByType(foodType: FoodType) {
        for (item: SingleCostRegistry in singleCostRegistryList) {
            if (item.foodType == foodType) {
                singleCostRegistryList.remove(item)
            }
        }
    }

    fun findBalance(): String = sharedPreferences.getString("BALANCE", "")

    fun saveCostRegistry(orderSummaryDto: OrderSummaryDto) {
        saveBalance(orderSummaryDto.balance.toString())
        setupList(orderSummaryDto)
        tenMinutesModel.addCostRegistry(CostRegistry(singleCostRegistryList.toList()))
    }

    fun uploadBalance(balance: Long) {
        saveBalance(balance.toString())
    }

    private fun saveBalance(balance: String) {
        val editor = sharedPreferences.edit()
        editor.putString("BALANCE", balance)
        editor.commit()
    }

    private fun setupList(orderSummaryDto: OrderSummaryDto) {
        singleCostRegistryList.clear()
        if (orderSummaryDto.typedCost > 0)
            singleCostRegistryList.add(SingleCostRegistry(FoodType.DEFAULT, orderSummaryDto.typedCost, LocalDateTime.now()))
        for (i in 1..orderSummaryDto.menuACount)
            singleCostRegistryList.add(SingleCostRegistry(FoodType.MENU_A, 900, LocalDateTime.now()))
        for (i in 1..orderSummaryDto.menuBCount)
            singleCostRegistryList.add(SingleCostRegistry(FoodType.MENU_B, 1090, LocalDateTime.now()))
        for (i in 1..orderSummaryDto.flavoredDressingCount)
            singleCostRegistryList.add(SingleCostRegistry(FoodType.FLAVORED_DRESSING, 100, LocalDateTime.now()))
    }
}