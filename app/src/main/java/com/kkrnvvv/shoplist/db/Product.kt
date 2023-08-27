package com.kkrnvvv.shoplist.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products_data_table")
class Product(
    @ColumnInfo(name = "item_name")
    var name: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)
