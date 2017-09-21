package com.adrian.tenminutesapp.pages.home.model

import android.content.SharedPreferences
import com.adrian.tenminutesapp.pages.home.dto.CostItem
import com.adrian.tenminutesapp.pages.home.dto.CostRegistry
import com.adrian.tenminutesapp.pages.home.dto.FoodType
import com.adrian.tenminutesapp.pages.home.service.HomePageService


/**
 * Created by cadri on 2017. 09. 19..
 */

class HomePageModel constructor(val homePageService: HomePageService, val sharedPreferences: SharedPreferences) {

    var balance: Long = 10000

    var costRegistry: CostRegistry = CostRegistry(ArrayList<CostItem>())

    val menuACostItem: CostItem = CostItem(FoodType.MENU_A, 900)
    val menuBCostItem: CostItem = CostItem(FoodType.MENU_B, 1090)
    val flavoredDressingItem: CostItem = CostItem(FoodType.FLAVORED_DRESSING, 100)

    fun addMenuAItem() {
        costRegistry.add(menuACostItem)
    }

    fun addMenuBItem() {
        costRegistry.add(menuBCostItem)
    }

    fun addFlavoredDressingItem() {
        costRegistry.add(flavoredDressingItem)
    }

    fun removeMenuAItem() {
        costRegistry.remove(menuACostItem)
    }

    fun removeMenuBItem() {
        costRegistry.remove(menuBCostItem)
    }

    fun removeFlavoredDressingItem() {
        costRegistry.remove(flavoredDressingItem)
    }

    fun saveBalance(balance: String) {
        val editor = sharedPreferences.edit()
        editor.putString("BALANCE", balance)
        editor.commit()
    }

    fun findBalance(): String {
        return sharedPreferences.getString("BALANCE", "")
    }


}