package com.adrian.tenminutesapp.pages.tenminutes.subpages.home.viewmodel

import android.databinding.Bindable
import android.view.View
import com.adrian.tenminutesapp.BR
import com.adrian.tenminutesapp.base.BaseViewModel
import com.adrian.tenminutesapp.pages.tenminutes.dto.SingleCostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.subpages.home.model.HomePageModel
import com.adrian.tenminutesapp.pages.tenminutes.viewmodel.TenMinutesViewModel

/**
 * Created by cadri on 2017. 09. 21..
 */

class HomePageViewModel constructor(val model: HomePageModel) : BaseViewModel() {

    object logging {
        val TAG = TenMinutesViewModel::class.java.simpleName
    }

    @Bindable
    var balance: Long = 0
        set(value) {
            if (balance != value) {
                field = value
                notifyPropertyChanged(BR.balance)
            }
        }

    @Bindable
    var cost: String = ""
        set(value) {
            if (cost != value) {
                field = value
                notifyPropertyChanged(BR.cost)
                notifySumCost()
            }
        }

    @Bindable
    var sumCost: String = ""
        set(value) {
            if (sumCost != value) {
                field = value
                notifyPropertyChanged(BR.sumCost)
            }
        }

    @Bindable
    var uploadBalanceAmount: String = ""
        set(value) {
            if (uploadBalanceAmount != value) {
                field = value
                notifyPropertyChanged(BR.uploadBalanceAmount)
            }
        }

    @Bindable
    var menuA: Boolean = false
        set(value) {
            if (menuA != value) {
                field = value
                notifyPropertyChanged(BR.menuA)
            }
        }

    @Bindable
    var menuB: Boolean = false
        set(value) {
            if (menuB != value) {
                field = value
                notifyPropertyChanged(BR.menuB)
            }
        }

    @Bindable
    var flavoredDressing: Boolean = false
        set(value) {
            if (flavoredDressing != value) {
                field = value
                notifyPropertyChanged(BR.flavoredDressing)
            }
        }

    @Bindable
    var moreItems: String = ""
        set(value) {
            if (moreItems != value) {
                field = value
                notifyPropertyChanged(BR.moreItems)
            }
        }

    override fun onCreate() {
        balance = parseToLongFromEditText(model.findBalance())
    }

    fun onClickAdd(view: View) {
        val cost = parseToLongFromEditText(sumCost)
        addNewCost(cost)
        reset()
    }

    fun onClickUploadBalance(view: View) {
        val amount = parseToLongFromEditText(uploadBalanceAmount)
        uploadBalance(amount)
        uploadBalanceAmount = ""
    }

    fun onClickMenuA(view: View) {
        menuA = !menuA
        if (menuA) {
            model.addMenuAItem()
        } else {
            model.removeMenuAItem()
        }
        notifyWhenAddOrRemoveItem()
    }

    fun onClickMenuB(view: View) {
        menuB = !menuB
        if (menuB) {
            model.addMenuBItem()
        } else {
            model.removeMenuBItem()
        }
        notifyWhenAddOrRemoveItem()
    }

    fun onClickFlavoredDressing(view: View) {
        flavoredDressing = !flavoredDressing
        if (flavoredDressing) {
            model.addFlavoredDressingItem()
        } else {
            model.removeFlavoredDressingItem()
        }
        notifyWhenAddOrRemoveItem()
    }

    private fun addNewCost(cost: Long) {
        balance -= cost
//        model.saveBalance(balance.toString())
        model.saveCostRegistry(balance.toString())
    }

    private fun uploadBalance(uploadBalanceAmount: Long) {
        var discount = uploadBalanceAmount / 10
        var uploadAmountWithDiscount = uploadBalanceAmount + discount
        this.balance += uploadAmountWithDiscount

        model.saveBalance(balance.toString())
        this.uploadBalanceAmount = ""
    }

    private fun notifyWhenAddOrRemoveItem() {
        moreItems = ""
        var cost: Long = 0
        for (singleCostRegistry: SingleCostRegistry in model.costRegistry.singleCostRegistries) {
            moreItems += ("+ " + singleCostRegistry.price.toString() + ", ")
            cost += singleCostRegistry.price
        }
        notifySumCost()
    }

    private fun notifySumCost() {
        var currentCost = parseToLongFromEditText(cost)
        sumCost = (currentCost + summarizeMoreItemCost()).toString()
    }

    private fun summarizeMoreItemCost(): Long {
        var cost: Long = 0
        for (singleCostRegistry: SingleCostRegistry in model.costRegistry.singleCostRegistries) {
            cost += singleCostRegistry.price
        }
        return cost
    }

    private fun reset() {
        cost = ""
        sumCost = ""
        moreItems = ""
        menuA = false;
        menuB = false;
        flavoredDressing = false
        model.costRegistry.singleCostRegistries.clear()
    }

    fun setupBalance(newBalance: String) {
        balance = parseToLongFromEditText(newBalance)
        model.saveBalance(balance.toString())
        uploadBalanceAmount = ""
    }

    private fun parseToLongFromEditText(text: String): Long {
        return if (!text.equals("")) {
            text.toLong()
        } else {
            0.toLong()
        }
    }


}