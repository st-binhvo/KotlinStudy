package com.example.kotlinknowledge.presentation.discover.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinknowledge.domain.model.CategoriesModel
import com.example.kotlinknowledge.domain.repositories.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor (
    private val repository: ProductRepository
) : ViewModel() {
    val categories = MutableLiveData<ArrayList<CategoriesModel.ListCategoriesModelItem>>()

    fun getCategories(){
        viewModelScope.launch {
            try {
                val response: ArrayList<CategoriesModel.ListCategoriesModelItem> = repository.getCategories()
                categories.value = ArrayList(
                    response.map {
                        it.copy(
                            url = repository.getDynamicImage(
                                backgroundColor = generateRandomColorCode(),
                                fontSize = 70,
                                text = it.name ?: ""
                            )
                        )
                    }
                )

            } catch (e: Exception){
                Log.d("ErrorTag", "${e.message}")
            }
        }
    }

    private fun generateRandomColorCode(): String {
        val charPool : List<Char> = ('0'..'9') + ('A'..'F')
        return (1..6)
            .map { kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("")
    }
}