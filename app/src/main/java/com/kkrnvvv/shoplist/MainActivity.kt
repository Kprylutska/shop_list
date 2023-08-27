package com.kkrnvvv.shoplist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kkrnvvv.shoplist.databinding.ActivityMainBinding
import com.kkrnvvv.shoplist.db.Product
import com.kkrnvvv.shoplist.db.ProductDatabase
import com.kkrnvvv.shoplist.repositories.ProductRepository
import com.kkrnvvv.shoplist.ui.AddDialogListener
import com.kkrnvvv.shoplist.ui.AddProductItemDialog
import com.kkrnvvv.shoplist.ui.ProductAdapter
import com.kkrnvvv.shoplist.ui.ProductViewModel
import com.kkrnvvv.shoplist.ui.ProductViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database by lazy { ProductDatabase.getDatabase(this) }
        val repository = ProductRepository(database)
        val factory = ProductViewModelFactory(repository)

        val viewModel = ViewModelProvider(this,factory).get(ProductViewModel::class.java)

        var adapter = ProductAdapter(listOf(), viewModel)
        binding.rvProduct.layoutManager = LinearLayoutManager(this)
        binding.rvProduct.adapter = adapter

        viewModel.getAllItems().observe(this, Observer {
            adapter.products = it
            adapter.notifyDataSetChanged()
        })

        binding.dialogButton.setOnClickListener{
            AddProductItemDialog(this, object : AddDialogListener {
                override fun onAddButtonClicked(product: Product) {
                    viewModel.upsert(product)
                }
            }).show()
        }

    }

}