package com.kkrnvvv.shoplist.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(product: Product)

    @Delete
    suspend fun delete(product: Product)

    @Query("SELECT * FROM products_data_table")
    fun getAllItems(): LiveData<List<Product>>
}