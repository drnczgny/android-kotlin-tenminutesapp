package com.adrian.tenminutesapp.pages.tenminutes.subpages.history.viewmodel

import android.databinding.Bindable
import com.adrian.tenminutesapp.BR
import com.adrian.tenminutesapp.R
import com.adrian.tenminutesapp.base.ListItemViewModel
import com.adrian.tenminutesapp.pages.tenminutes.dto.FoodType
import com.adrian.tenminutesapp.pages.tenminutes.dto.SingleCostRegistry
import org.threeten.bp.LocalDate

/**
 * Created by cadri on 2017. 09. 23..
 */

class CostRegistryItemViewModel  : ListItemViewModel() {

    init {

    }

    @Bindable
    var singleCostRegistrieItemViewModels: MutableList<SingleCostRegistryItemViewModel> = mutableListOf(
            SingleCostRegistryItemViewModel(SingleCostRegistry(FoodType.DEFAULT, 1000, LocalDate.now())),
            SingleCostRegistryItemViewModel(SingleCostRegistry(FoodType.DEFAULT, 2000, LocalDate.now())))
        set(value) {
            if (!singleCostRegistrieItemViewModels.equals(value)) {
                field = value
            }
        }

    @Bindable
    fun getItemLayoutId() = R.layout.list_item_single_cost_registry

    @Bindable
    fun getVariableId(): Int {
        return BR.viewModel
    }

}