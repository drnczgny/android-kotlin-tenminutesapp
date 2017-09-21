package com.adrian.tenminutesapp.pages.tenminutes.subpages.home.model

import android.content.SharedPreferences
import com.adrian.tenminutesapp.pages.tenminutes.dto.CostItem
import com.adrian.tenminutesapp.pages.tenminutes.dto.CostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.dto.FoodType
import com.adrian.tenminutesapp.pages.tenminutes.subpages.home.service.HomePageService
import org.threeten.bp.LocalDate


/**
 * Created by cadri on 2017. 09. 19..
 */

class HomePageModel constructor(val homePageService: HomePageService, val sharedPreferences: SharedPreferences) {

    var costRegistry: CostRegistry = CostRegistry(ArrayList<CostItem>())


    fun addMenuAItem() {
        costRegistry.add(CostItem(FoodType.MENU_A, 900, LocalDate.now()))
    }

    fun addMenuBItem() {
        costRegistry.add(CostItem(FoodType.MENU_B, 1090, LocalDate.now()))
    }

    fun addFlavoredDressingItem() {
        costRegistry.add(CostItem(FoodType.FLAVORED_DRESSING, 100, LocalDate.now()))
    }

    fun removeMenuAItem() {
        costRegistry.remove(0)
    }

    fun removeMenuBItem() {
        costRegistry.remove(0)
    }

    fun removeFlavoredDressingItem() {
        costRegistry.remove(0)
    }

    fun addItem(price: Long) {
        costRegistry.add(CostItem(FoodType.DEFAULT, price, LocalDate.now()))
    }

    fun saveBalance(balance: String) {
        val editor = sharedPreferences.edit()
        editor.putString("BALANCE", balance)
        editor.commit()
    }

    fun findBalance(): String = sharedPreferences.getString("BALANCE", "")



}