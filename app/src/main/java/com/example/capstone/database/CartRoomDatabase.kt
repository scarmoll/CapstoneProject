package com.example.capstone.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.capstone.Data.IndividualPart
import com.example.capstone.dao.CartDao

@Database(entities = [IndividualPart::class], version = 1, exportSchema = false)
abstract class CartRoomDatabase : RoomDatabase() {

    abstract fun cartDao(): CartDao

    companion object {
        private const val DATABASE_NAME = "CART_DATABASE"

        @Volatile
        private var INSTANCE: CartRoomDatabase? = null

        fun getDatabase(context: Context): CartRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(CartRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            CartRoomDatabase::class.java, DATABASE_NAME
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }

}
