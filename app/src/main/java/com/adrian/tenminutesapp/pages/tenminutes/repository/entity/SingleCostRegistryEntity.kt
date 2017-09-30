package com.adrian.tenminutesapp.pages.tenminutes.repository.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by cadri on 2017. 09. 27..
 */

@Entity(tableName = "SingleCostRegistry")
data class SingleCostRegistryEntity constructor(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val foodType: String,
        val price: Long,
        val dateTime: String) {
}