package com.kkrnvvv.shoplist.repositories

import com.kkrnvvv.shoplist.db.Product
import com.kkrnvvv.shoplist.db.ProductDatabase

class ProductRepository(private val db: ProductDatabase) {

    suspend fun upsert(product: Product) = db.productDao().upsert(product)

    suspend fun delete(product: Product) = db.productDao().delete(product)

    fun getAllItems() = db.productDao().getAllItems()

}