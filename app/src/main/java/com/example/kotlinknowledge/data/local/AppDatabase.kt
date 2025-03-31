package com.example.kotlinknowledge.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlinknowledge.data.local.dao.FavoriteProductDao
import com.example.kotlinknowledge.domain.model.FavoriteProduct

@Database(entities = [FavoriteProduct::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteProductDao(): FavoriteProductDao
}