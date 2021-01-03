package com.example.capstone.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.capstone.Data.IndividualPart
import com.example.capstone.repository.CartRepository
import kotlinx.coroutines.*
import java.util.*

class CartViewModel(application: Application) : AndroidViewModel(application) {

    private val cartRepository = CartRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)

    val cart = cartRepository.getCart()
    val error = MutableLiveData<String>()
    val success = MutableLiveData<Boolean>()

    fun insertPart(name: String, price: Double) {
        val newPart = IndividualPart(
            name = name,
            price = price
        )

        mainScope.launch {
            withContext(Dispatchers.IO) {
                cartRepository.insertPart(newPart)
            }
            success.value = true
        }
    }

    fun clearCart() {
        MainScope().launch {
            withContext(Dispatchers.IO) {
                cartRepository.clearCart()
            }
        }
    }

    fun deletePart(part: IndividualPart) {
        MainScope().launch {
            withContext(Dispatchers.IO) {
                cartRepository.deletePart(part)
            }
        }
    }
}