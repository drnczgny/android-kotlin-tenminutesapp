package com.adrian.tenminutesapp.pages.tenminutes.model

import android.util.Log
import com.adrian.tenminutesapp.db.TenMinutesDatabase
import com.adrian.tenminutesapp.pages.tenminutes.dto.CostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.dto.FoodType
import com.adrian.tenminutesapp.pages.tenminutes.dto.SingleCostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.repository.converter.convertSingleCostRegistryToSingleCostRegistryEntity
import com.adrian.tenminutesapp.pages.tenminutes.repository.entity.SingleCostRegistryEntity
import org.threeten.bp.LocalDateTime
import rx.Observable
import rx.Single
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subjects.PublishSubject

/**
 * Created by cadri on 2017. 09. 23..
 */

class TenMinutesModel(val database: TenMinutesDatabase) {

    object logging {
        val TAG = TenMinutesModel::class.java.simpleName
    }

    private var costRegistryList: MutableList<CostRegistry> = ArrayList()

    private var addNewCostRegistryPublisher: PublishSubject<CostRegistry> = PublishSubject.create();

    init {
        costRegistryList = testHistory()
    }

    fun provideCostRegistryList() = costRegistryList.toList()

    fun addCostRegistry(costRegistry: CostRegistry) {
        costRegistryList.add(0, costRegistry)
        Log.e(logging.TAG, "list: " + costRegistryList.toString())
        addNewCostRegistryPublisher.onNext(costRegistry)
    }

    fun observeAddNewCostRegistryPublisher(): Observable<CostRegistry>
            = addNewCostRegistryPublisher

    fun saveSingleCostRegistry(singleCostRegistry: SingleCostRegistry) {
//        database.singleCostRegistryEntityDao().insert(convertSingleCostRegistryToSingleCostRegistryEntity(singleCostRegistry))
        Single.fromCallable {
            database.singleCostRegistryEntityDao()?.insert(convertSingleCostRegistryToSingleCostRegistryEntity(singleCostRegistry))
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe()
    }

    fun findAllSingleCostRegistry() {
//        database.singleCostRegistryEntityDao().findAll()
        Single.fromCallable {
            database.singleCostRegistryEntityDao().findAll()
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object: Subscriber<List<SingleCostRegistryEntity>>() {
                    override fun onCompleted() {
                        // Completed
                    }

                    override fun onError(e: Throwable?) {
                        // Error
                    }

                    override fun onNext(costRegistry: List<SingleCostRegistryEntity>) {
                        Log.e(logging.TAG, "adsadsd")
                    }
                })
//                .subscribe(object: Subscriber<List<SingleCostRegistry>>() {
//            override fun onCompleted() {
//                // Completed
//            }
//
//            override fun onError(e: Throwable?) {
//                // Error
//            }
//
//            override fun onNext(singleCostRegistry: List<SingleCostRegistry>) {
////                notifyNewCostRegistryAdded(singleCostRegistry)
//            }
//        })
    }

    private fun testHistory(): MutableList<CostRegistry> {
        val costRegistry1 = CostRegistry(listOf<SingleCostRegistry>(
                SingleCostRegistry(FoodType.DEFAULT, 1000, LocalDateTime.now()),
                SingleCostRegistry(FoodType.DEFAULT, 2000, LocalDateTime.now()),
                SingleCostRegistry(FoodType.DEFAULT, 3000, LocalDateTime.now())) as MutableList<SingleCostRegistry>)
        val costRegistry2 = CostRegistry(listOf<SingleCostRegistry>(
                SingleCostRegistry(FoodType.DEFAULT, 1500, LocalDateTime.now()),
                SingleCostRegistry(FoodType.DEFAULT, 2500, LocalDateTime.now()),
                SingleCostRegistry(FoodType.DEFAULT, 3500, LocalDateTime.now())) as MutableList<SingleCostRegistry>)
        return mutableListOf(costRegistry1, costRegistry2)
    }
}