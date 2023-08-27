package com.kkrnvvv.shoplist.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.kkrnvvv.shoplist.databinding.DialogAddItemBinding
import com.kkrnvvv.shoplist.db.Product

class AddProductItemDialog(context: Context, var addDialogListener: AddDialogListener) : AppCompatDialog(context) {

    private lateinit var binding: DialogAddItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DialogAddItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClickListener{
            val name = binding.inputName.text.toString()

            if (name.isEmpty()){
                Toast.makeText(context, "Please enter a name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = Product(name)
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }
        binding.cancelButton.setOnClickListener{
            cancel()
        }

    }
}