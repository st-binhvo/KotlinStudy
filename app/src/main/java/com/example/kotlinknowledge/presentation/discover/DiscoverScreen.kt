package com.example.kotlinknowledge.presentation.discover

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kotlinknowledge.presentation.discover.viewmodel.DiscoverViewModel
import com.example.kotlinknowledge.presentation.discover.widget.CategoriesWidget
import com.example.kotlinknowledge.presentation.discover.widget.DiscoveryHeader
import com.example.kotlinknowledge.presentation.discover.widget.SearchHeader

@Composable
fun DiscoverScreen(modifier: Modifier = Modifier,goToSearchScreen: ()-> Unit) {
    val discoverViewModel: DiscoverViewModel = hiltViewModel<DiscoverViewModel>()
    LaunchedEffect(Unit) {
        discoverViewModel.getCategories()
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                color = Color.White
            )
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            DiscoveryHeader(modifier)
            SearchHeader(goToSearchScreen= goToSearchScreen)
            CategoriesWidget(discoverViewModel)
        }
    }

}
