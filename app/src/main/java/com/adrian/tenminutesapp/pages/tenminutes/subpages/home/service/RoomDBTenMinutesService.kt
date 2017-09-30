package com.adrian.tenminutesapp.pages.tenminutes.subpages.home.service

import com.adrian.tenminutesapp.db.TenMinutesDatabase
import com.adrian.tenminutesapp.pages.tenminutes.dto.SingleCostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.repository.converter.convertSingleCostRegistryToSingleCostRegistryEntity
import com.adrian.tenminutesapp.pages.tenminutes.repository.entity.SingleCostRegistryEntity
import org.threeten.bp.LocalDateTime
import rx.Single
import rx.schedulers.Schedulers

/**
 * Created by cadri on 2017. 09. 30..
 */

class RoomDBTenMinutesService constructor(val database: TenMinutesDatabase) : TenMinutesService {

    object logging {
        val TAG = RoomDBTenMinutesService::class.java.simpleName
    }

    override fun findAllSingleCostRegistry(): Single<List<SingleCostRegistryEntity>> {
        return Single.fromCallable {
            database.singleCostRegistryEntityDao().findAll()
        }.subscribeOn(Schedulers.io())
    }

    override fun findSingleCostRegistry(singleCostRegistry: SingleCostRegistry) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findSingleCostRegistryById(id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findSingleCostRegistryByDateTime(dateTime: LocalDateTime) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findSingleCostRegistryByDateTime(timeInMillis: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveSingleCostRegistry(singleCostRegistry: SingleCostRegistry): Single<Unit> {
        return Single.fromCallable {
            database.singleCostRegistryEntityDao()?.insert(convertSingleCostRegistryToSingleCostRegistryEntity(singleCostRegistry))
        }.subscribeOn(Schedulers.io())
    }

    override fun saveSingleCostRegistries(singleCostRegistries: List<SingleCostRegistry>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteSingleCostRegistry(singleCostRegistry: SingleCostRegistry) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteSingleCostRegistryById(id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insertSingleCostRegistry(singleCostRegistry: SingleCostRegistry) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateSingleCostRegistry(singleCostRegistry: SingleCostRegistry) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}