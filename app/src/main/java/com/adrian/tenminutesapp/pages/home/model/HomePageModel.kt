package com.adrian.tenminutesapp.pages.home.model

import com.adrian.tenminutesapp.pages.home.service.HomePageService
import com.adrian.tenminutesapp.pages.home.dto.CostItem
import com.adrian.tenminutesapp.pages.home.dto.CostRegistry

/**
 * Created by cadri on 2017. 09. 19..
 */

class HomePageModel constructor(val homePageService: HomePageService) {

    var balance: Long = 10000

    var costRegistry: CostRegistry = CostRegistry(ArrayList<CostItem>())

    val menuACostItem: CostItem = CostItem("Menu A", 900)
    val menuBCostItem: CostItem = CostItem("Menu B", 1090)
    val flavoredDressingItem: CostItem = CostItem("Flavored dressing", 100)


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

//    fun addCost(cost: Long) {
//        balance -= cost
//    }
//
//    fun uploadBalance(newBalance: Long) {
//        balance = newBalance
//    }

}