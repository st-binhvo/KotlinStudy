package com.example.kotlinknowledge.domain.model

import androidx.room.*

@Entity
data class FavoriteProduct (
    @PrimaryKey val id: Int?,
    val title: String,
    val userId: String?, // this field for apply filter favorite product by user
)