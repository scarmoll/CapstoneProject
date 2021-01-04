package com.example.capstone.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.capstone.model.IndividualPart
import com.example.capstone.repository.CartRepository
import kotlinx.coroutines.*

class CartViewModel(application: Application) : AndroidViewModel(application) {

    private val cartRepository = CartRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)

    val cart = cartRepository.getCart()
    val error = MutableLiveData<String>()
    val success = MutableLiveData<Boolean>()

    fun insertPart(individualPart: IndividualPart) {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                cartRepository.insertPart(individualPart)
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