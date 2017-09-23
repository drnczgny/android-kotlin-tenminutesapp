package com.adrian.tenminutesapp.pages.tenminutes.subpages.home.model

import android.content.SharedPreferences
import com.adrian.tenminutesapp.pages.tenminutes.dto.CostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.dto.FoodType
import com.adrian.tenminutesapp.pages.tenminutes.dto.SingleCostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.model.TenMinutesModel
import com.adrian.tenminutesapp.pages.tenminutes.subpages.history.dto.History
import com.adrian.tenminutesapp.pages.tenminutes.subpages.home.service.HomePageService
import org.threeten.bp.LocalDate


/**
 * Created by cadri on 2017. 09. 19..
 */

class HomePageModel constructor(val tenMinutesModel: TenMinutesModel, val homePageService: HomePageService, val sharedPreferences: SharedPreferences) {

    var costRegistry: CostRegistry = CostRegistry(ArrayList<SingleCostRegistry>())

    fun addMenuAItem() {
        costRegistry.add(SingleCostRegistry(FoodType.MENU_A, 900, LocalDate.now()))
    }

    fun addMenuBItem() {
        costRegistry.add(SingleCostRegistry(FoodType.MENU_B, 1090, LocalDate.now()))
    }

    fun addFlavoredDressingItem() {
        costRegistry.add(SingleCostRegistry(FoodType.FLAVORED_DRESSING, 100, LocalDate.now()))
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
        costRegistry.add(SingleCostRegistry(FoodType.DEFAULT, price, LocalDate.now()))
    }

    fun saveBalance(balance: String) {
        val editor = sharedPreferences.edit()
        editor.putString("BALANCE", balance)
        editor.commit()
    }

    fun findBalance(): String = sharedPreferences.getString("BALANCE", "")

    fun saveCostRegistry(balance: String) {
        saveBalance(balance)
        tenMinutesModel.addHistory(History(costRegistry))
    }


}