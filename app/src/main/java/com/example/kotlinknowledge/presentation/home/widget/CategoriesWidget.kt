package com.example.kotlinknowledge.presentation.home.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.kotlinknowledge.app.theme.AppStyle
import com.example.kotlinknowledge.presentation.home.viewmodel.HomeViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CategoriesWidget(homeViewModel: HomeViewModel) {
    val categories by homeViewModel.categories.observeAsState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = AppStyle.appPadding.xmd)
    ) {
        if (categories.isNullOrEmpty()) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.width(32.dp),
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                )
            }
        } else {
            categories?.let {
                LazyRow {
                    items(categories!!) {
                        it.name?.let { name ->
                            Column(
                                modifier = Modifier.padding(end = AppStyle.appPadding.xl),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(42.dp)
                                        .background(
                                            AppStyle.appColor.kBackground,
                                            shape = CircleShape
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        Icons.Outlined.Face,
                                        modifier = Modifier
                                            .size(17.dp),
                                        contentDescription = "ic_category",
                                        tint = AppStyle.appColor.kBlack,
                                    )
                                }
                                Text(
                                    text = name,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}