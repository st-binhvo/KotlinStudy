package com.example.kotlinknowledge.domain.model

class CategoriesModel : ArrayList<CategoriesModel.ListCategoriesModelItem>(){
    data class ListCategoriesModelItem(
        val name: String?,
        val slug: String?,
        val url: String?
    )
}