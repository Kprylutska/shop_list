package com.kkrnvvv.shoplist.ui

import com.kkrnvvv.shoplist.db.Product

interface AddDialogListener {

    fun onAddButtonClicked(product: Product)
}