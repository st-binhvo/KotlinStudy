package com.example.kotlinknowledge.presentation.home.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.example.kotlinknowledge.app.theme.AppStyle
import com.example.kotlinknowledge.domain.model.ProductsModel.Product
import com.example.kotlinknowledge.presentation.home.viewmodel.HomeViewModel


@Composable
fun Recommended(homeViewModel: HomeViewModel) {
    Column {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Recommended",
                style = AppStyle.appFont.bold(20.sp),
            )
            Text(
                text = "Show all",
                style = AppStyle.appFont.regular(14.sp),
            )
        }
        ListRecommendedHorizontal(homeViewModel)
    }
}

@Composable
fun ListRecommendedHorizontal(homeViewModel: HomeViewModel) {
    val featureProducts by homeViewModel.featureProducts.observeAsState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = AppStyle.appPadding.xxsm, bottom = AppStyle.appPadding.xxsm)
    ) {
        if (featureProducts?.products.isNullOrEmpty()) {
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
            featureProducts?.let {
                LazyRow {
                    items(featureProducts!!.products!!) {
                        it?.let {
                            ItemCard(it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ItemCard(product: Product) {
    Row(
        modifier = Modifier
            .size(width = 213.dp, height = 66.dp)
            .padding(end = AppStyle.appPadding.xxsm)
            .border(
                width = 0.7.dp,
                color = AppStyle.appColor.kGreyBackground,
                shape = RoundedCornerShape(16.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier
                .size(width = 66.dp, height = 66.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(color = AppStyle.appColor.kGreyBackground)
                .border(
                    width = 0.7.dp,
                    color = AppStyle.appColor.kGreyBackground,
                    shape = RoundedCornerShape(16.dp)
                ),
            model = ImageRequest.Builder(LocalContext.current)
                .data(product.thumbnail)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Fit,
        )
        Column(
            modifier = Modifier
                .padding(9.dp)
        ) {
            product.title?.let { Text(it, style = AppStyle.appFont.regular(12.sp)) }
            Box(modifier = Modifier.padding(top = 4.dp))
            Text("$ ${product.price}",style = AppStyle.appFont.bold(16.sp))
        }

    }
}