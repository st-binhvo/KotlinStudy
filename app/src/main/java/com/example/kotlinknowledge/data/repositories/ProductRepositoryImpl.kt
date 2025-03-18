package com.example.kotlinknowledge.data.repositories

import com.example.kotlinknowledge.domain.model.CategoriesModel
import com.example.kotlinknowledge.domain.model.ProductsModel
import com.example.kotlinknowledge.data.remote.api.ProductServices
import com.example.kotlinknowledge.domain.repositories.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private  val services: ProductServices
): ProductRepository {

    override suspend fun getProducts(limit: String, skip: String): ProductsModel {
       return services.getProducts(limit,skip)
    }

    override suspend fun getCategories(): CategoriesModel {
        return services.getCategories()
    }

    // https://dummyjson.com/image/SIZE/BACKGROUND/COLOR
    override fun getDynamicImage(
        width: Int,
        height: Int,
        backgroundColor: String,
        text: String,
        textColor: String,
        fontSize: Int,
    ): String {
        return "https://dummyjson.com/image/${width}x${height}/${backgroundColor}/${textColor}?text=${text}&fontSize=${fontSize}"
    }
}