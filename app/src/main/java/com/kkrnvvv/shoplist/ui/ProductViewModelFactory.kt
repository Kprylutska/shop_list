package com.kkrnvvv.shoplist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kkrnvvv.shoplist.repositories.ProductRepository

class ProductViewModelFactory(private val repository: ProductRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(repository) as T
    }
}