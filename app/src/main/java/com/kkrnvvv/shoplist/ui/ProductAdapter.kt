package com.kkrnvvv.shoplist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kkrnvvv.shoplist.databinding.ShoppingItemBinding
import com.kkrnvvv.shoplist.db.Product

class ProductAdapter(
    var products: List<Product>,
    private val viewModel: ProductViewModel
): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ShoppingItemBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val curProductItem = products[position]
        with(holder.binding) {
            with(curProductItem) {
                productName.text = this.name

                deleteButton.setOnClickListener {
                    viewModel.delete(curProductItem)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

    inner class ProductViewHolder(val binding: ShoppingItemBinding): RecyclerView.ViewHolder(binding.root)
}