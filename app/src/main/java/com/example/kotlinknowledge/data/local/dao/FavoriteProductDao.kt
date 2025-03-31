package com.example.kotlinknowledge.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlinknowledge.domain.model.FavoriteProduct
import com.example.kotlinknowledge.domain.model.ProductsModel

@Dao
interface FavoriteProductDao {
    @Query("SELECT * FROM favoriteproduct")
    fun getAll(): List<FavoriteProduct>

    @Query("SELECT * FROM favoriteproduct WHERE id IN (:productIds)")
    fun loadAllByIds(productIds: IntArray): List<FavoriteProduct>

    @Query("SELECT * FROM favoriteproduct WHERE title LIKE :name LIMIT 1")
    fun findByName(name: String): FavoriteProduct

    @Insert
    fun insertAll(product: FavoriteProduct)

    @Delete
    fun delete(product: FavoriteProduct)
}