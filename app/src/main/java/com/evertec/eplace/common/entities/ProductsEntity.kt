package com.evertec.eplace.common.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ProductsEntity")
data class ProductsEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var nameProduct: String,
    var priceProduct: Int = 0
)