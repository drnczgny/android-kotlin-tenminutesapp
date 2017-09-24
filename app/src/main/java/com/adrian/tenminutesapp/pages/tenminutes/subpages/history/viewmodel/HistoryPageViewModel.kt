package com.adrian.tenminutesapp.pages.tenminutes.subpages.history.viewmodel

import android.databinding.Bindable
import com.adrian.tenminutesapp.BR
import com.adrian.tenminutesapp.R
import com.adrian.tenminutesapp.base.BaseViewModel
import com.adrian.tenminutesapp.pages.tenminutes.subpages.history.model.HistoryPageModel
import com.adrian.tenminutesapp.pages.tenminutes.subpages.history.view.HistoryPageRouter

/**
 * Created by cadri on 2017. 09. 23..
 */

class HistoryPageViewModel constructor(router: HistoryPageRouter, model: HistoryPageModel) : BaseViewModel() {

    @Bindable
    var costRegistryItemViewModels: MutableList<CostRegistryItemViewModel> = mutableListOf(CostRegistryItemViewModel(), CostRegistryItemViewModel())

//    @Bindable
//    var costRegistryItemViewModels: MutableList<TempListItemViewModel> = mutableListOf(TempListItemViewModel(), TempListItemViewModel())
//        set(value) {
//            if (!costRegistryItemViewModels.equals(value)) {
//                field = value
//            }
//        }

    override fun onCreate() {

    }


    @Bindable
    fun getItemLayoutId() = R.layout.list_item_cost_registry

    @Bindable
    fun getVariableId(): Int {
        return BR.viewModel
    }

}