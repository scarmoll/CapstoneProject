package com.example.capstone.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.capstone.Data.IndividualPart
import com.example.capstone.dao.CartDao
import com.example.capstone.database.CartRoomDatabase

class CartRepository(context: Context) {

    private val cartDao: CartDao

    init {
        val database = CartRoomDatabase.getDatabase(context)
        cartDao = database!!.cartDao()
    }

    fun getCart(): LiveData<List<IndividualPart>> {
        return cartDao.getCart()
    }

    suspend fun insertPart(part: IndividualPart) {
        cartDao.insertPart(part)
    }

    suspend fun deletePart(part: IndividualPart) {
        cartDao.deletePart(part)
    }

    suspend fun clearCart() {
        cartDao.clearCart()
    }

}