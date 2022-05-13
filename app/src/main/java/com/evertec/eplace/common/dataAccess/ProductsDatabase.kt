package com.evertec.eplace.common.dataAccess

import androidx.room.Database
import androidx.room.RoomDatabase
import com.evertec.eplace.common.entities.ProductsEntity

@Database(entities = [ProductsEntity::class], version = 1)
abstract class ProductsDatabase : RoomDatabase() {

    abstract fun ProductsDao(): ProductsDao
}