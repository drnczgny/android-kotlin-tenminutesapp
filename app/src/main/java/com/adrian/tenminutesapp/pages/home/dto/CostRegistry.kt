package com.adrian.tenminutesapp.pages.home.dto

/**
 * Created by cadri on 2017. 09. 19..
 */

data class CostRegistry(val costItems: MutableList<CostItem>) {

    fun add(costItem: CostItem) {
        costItems.add(costItem)
    }

    fun remove(id: Int) {
        costItems.removeAt(id)
    }
}