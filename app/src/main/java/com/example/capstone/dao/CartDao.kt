package com.example.capstone.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.capstone.Data.IndividualPart

@Dao
interface CartDao {

    @Insert
    suspend fun insertPart(part: IndividualPart)

    @Query("SELECT * FROM CartTable ")
    fun getCart(): LiveData<List<IndividualPart>>

    @Delete
    suspend fun deletePart(part: IndividualPart)

    @Query("DELETE FROM CartTable")
    suspend fun clearCart()

}