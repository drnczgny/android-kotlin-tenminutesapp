package com.adrian.tenminutesapp.pages.tenminutes.repository.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by cadri on 2017. 09. 30..
 */

@Entity(tableName = "CostRegistry")
class CostRegistryEntity constructor(
        @PrimaryKey(autoGenerate = true) val id: Long,
        var singleCostRegistryEntities: List<SingleCostRegistryEntity>) {

    constructor() : this(0, emptyList())
}