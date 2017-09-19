package com.adrian.tenminutesapp.pages.home.viewmodel

import android.databinding.Bindable
import android.util.Log
import android.view.View
import com.adrian.tenminutesapp.BR
import com.adrian.tenminutesapp.base.BaseViewModel
import com.adrian.tenminutesapp.pages.home.dto.CostItem
import com.adrian.tenminutesapp.pages.home.model.HomePageModel
import com.adrian.tenminutesapp.pages.home.view.HomePageRouter

/**
 * Created by cadri on 2017. 09. 19..
 */

class HomePageViewModel constructor(val homePageRouter: HomePageRouter, val model: HomePageModel) : BaseViewModel() {

    object logging {
        val TAG = HomePageViewModel::class.java.simpleName
    }

    @Bindable
    var balance: Long = model.balance
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
//                if (cost.equals("")) {
//                    notifySumCost(0)
//                } else {
//                    notifySumCost(cost.toLong().times(-1))
//                }
                field = value
                notifyPropertyChanged(BR.cost)
                notifySumCost()
//                if (cost.equals("")) {
//                    notifySumCost(0)
//                } else {
//                    notifySumCost(cost.toLong())
//                }
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

    fun onClickAdd(view: View) {
        Log.e(logging.TAG, "onClickAdd...");
        if (!sumCost.equals("")) {
            addNewCost(sumCost.toLong())
        }
        reset()
    }

    fun onClickUploadBalance(view: View) {
        Log.e(logging.TAG, "onClickUploadBalance...");
        if (!uploadBalanceAmount.equals("")) {
            uploadBalance(uploadBalanceAmount.toLong())
        }
        uploadBalanceAmount = ""
    }

    fun onClickMenuA(view: View) {
        Log.e(logging.TAG, "onClickMenuA...");
        menuA = !menuA
        if (menuA) {
            model.addMenuAItem()
        } else {
            model.removeMenuAItem()
        }
        notifyWhenAddOrRemoveItem()
    }

    fun onClickMenuB(view: View) {
        Log.e(logging.TAG, "onClickMenuB...");
        menuB = !menuB
        if (menuB) {
            model.addMenuBItem()
        } else {
            model.removeMenuBItem()
        }
        notifyWhenAddOrRemoveItem()
    }

    fun onClickFlavoredDressing(view: View) {
        Log.e(logging.TAG, "onClickFlavoredDressing...");
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
    }

    private fun uploadBalance(uploadBalanceAmount: Long) {
        var discount = uploadBalanceAmount / 10
        var uploadAmountWithDiscount = uploadBalanceAmount + discount
        this.balance += uploadAmountWithDiscount
    }

    private fun notifyWhenAddOrRemoveItem() {
        moreItems = ""
        var cost: Long = 0
        for (costItem: CostItem in model.costRegistry.costItems) {
            moreItems += ("+ " + costItem.price.toString() + ", ")
            cost += costItem.price
        }
        notifySumCost()
    }


    private fun notifySumCost() {
        var currentCost = if (! cost.equals("")) {
            cost.toLong()
        } else {
            0
        }
        sumCost = (currentCost + summarizeMoreItemCost()).toString()
    }

    private fun summarizeMoreItemCost(): Long {
        var cost: Long = 0
        for (costItem: CostItem in model.costRegistry.costItems) {
            cost += costItem.price
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
        model.costRegistry.costItems.clear()
    }
}