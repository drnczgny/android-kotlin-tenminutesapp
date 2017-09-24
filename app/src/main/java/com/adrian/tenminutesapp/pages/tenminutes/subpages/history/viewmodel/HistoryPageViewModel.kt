package com.adrian.tenminutesapp.pages.tenminutes.subpages.history.viewmodel

import android.databinding.Bindable
import com.adrian.tenminutesapp.BR
import com.adrian.tenminutesapp.R
import com.adrian.tenminutesapp.base.BaseViewModel
import com.adrian.tenminutesapp.pages.tenminutes.dto.CostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.subpages.history.model.HistoryPageModel
import com.adrian.tenminutesapp.pages.tenminutes.subpages.history.view.HistoryPageRouter
import com.annimon.stream.Collectors
import com.annimon.stream.Stream


/**
 * Created by cadri on 2017. 09. 23..
 */

class HistoryPageViewModel constructor(router: HistoryPageRouter, model: HistoryPageModel) : BaseViewModel() {

    object logging {
        val TAG = HistoryPageViewModel::class.java.simpleName
    }

    @Bindable
    var costRegistryItemViewModels: List<CostRegistryItemViewModel> = convertToViewModels(model.findHistory())

    @Bindable
    fun getItemLayoutId() = R.layout.list_item_cost_registry

    @Bindable
    fun getVariableId(): Int {
        return BR.viewModel
    }

    override fun onCreate() {

    }

    private fun convertToViewModel(costRegistry: CostRegistry): CostRegistryItemViewModel {
        return CostRegistryItemViewModel(costRegistry)
    }

    private fun convertToViewModels(costRegistries: List<CostRegistry>): List<CostRegistryItemViewModel> {
        return Stream.of(costRegistries).map { costRegistry -> convertToViewModel(costRegistry) }.collect(Collectors.toList())
    }
}