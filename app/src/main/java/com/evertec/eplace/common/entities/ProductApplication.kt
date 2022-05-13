package com.evertec.eplace.common.entities

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.evertec.eplace.common.dataAccess.ProductsDatabase

class ProductApplication : Application() {

    companion object {
        lateinit var database: ProductsDatabase
    }

    override fun onCreate() {
        super.onCreate()

        val MIGRATION_1_2 = object : Migration(1,2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE ProductsEntity ADD COLUMN nameProduct TEXT NOT NULL DEFAULT ''")
            }
        }

        database = Room.databaseBuilder(
            this,
            ProductsDatabase::class.java,
            "StoreDatabase")
                .addMigrations(MIGRATION_1_2).build()
    }
}