package com.evertec.eplace.common.dataAccess

import androidx.room.*
import com.evertec.eplace.common.entities.ProductsEntity

@Dao
interface ProductsDao {
   // @Query("SELECT * FROM ProductsEntity WHERE code = :code")
  //  suspend fun consultCouponByCode(code: String): ProductsEntity?

  //  @Insert
  //  suspend fun addProduct(productsEntity: ProductsEntity ): Long

    @Query("SELECT * FROM ProductsEntity")
    fun getAllProducts(): MutableList<ProductsEntity>
}