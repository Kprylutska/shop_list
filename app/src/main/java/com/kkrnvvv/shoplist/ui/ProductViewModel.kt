package com.kkrnvvv.shoplist.ui

import androidx.lifecycle.ViewModel
import com.kkrnvvv.shoplist.db.Product
import com.kkrnvvv.shoplist.repositories.ProductRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepository): ViewModel() {

    fun upsert(product: Product) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(product)
    }

    fun delete(product: Product) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(product)
    }

    fun getAllItems() = repository.getAllItems()
}