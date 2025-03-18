package com.example.kotlinknowledge.domain.repositories

import com.example.kotlinknowledge.domain.model.CategoriesModel
import com.example.kotlinknowledge.domain.model.ProductsModel


interface  ProductRepository {
     suspend fun getProducts(limit: String,skip: String): ProductsModel

     suspend fun getCategories(): CategoriesModel

     // https://dummyjson.com/image/SIZE/BACKGROUND/COLOR
     fun getDynamicImage(
          width: Int = 1920,
          height: Int = 1080,
          backgroundColor: String = "eb9153",
          text: String = "Hello World",
          textColor: String = "ffffff",
          fontSize: Int = 16,
     ): String
}