package com.example.kotlinknowledge.presentation.discover.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.kotlinknowledge.app.theme.AppStyle
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import com.example.kotlinknowledge.domain.model.CategoriesModel
import com.example.kotlinknowledge.presentation.discover.viewmodel.DiscoverViewModel
import okhttp3.internal.toImmutableList

@Composable
fun CategoriesWidget(discoverViewModel: DiscoverViewModel) {
    val categories by discoverViewModel.categories.observeAsState()

    if (categories.isNullOrEmpty()) {
        Box(
            modifier = Modifier.fillMaxWidth().padding(top = AppStyle.appPadding.xxsm),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.width(32.dp),
                color = MaterialTheme.colorScheme.secondary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
            )
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
        ){
            categories?.let {
                categories!!.map {
                    CategoryItemBanner(it)
                }.toImmutableList()
            }
        }

    }
}

@Composable
fun CategoryItemBanner(item: CategoriesModel.ListCategoriesModelItem){
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(item.url)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(horizontal = AppStyle.appPadding.xxsm, vertical = AppStyle.appPadding.xxxs)
            .fillMaxWidth()
            .height(141.dp)
            .clip(RoundedCornerShape(AppStyle.appPadding.xxsm)),
        loading = {
            Box(
                Modifier
                    .padding(horizontal = AppStyle.appPadding.xxsm, vertical = AppStyle.appPadding.xxxs)
                    .fillMaxWidth()
                    .height(141.dp)
                    .clip(RoundedCornerShape(AppStyle.appPadding.xxsm))
                    .background(color = AppStyle.appColor.kDeepWhite),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator(
                    modifier = Modifier.width(32.dp).padding(bottom = 16.dp),
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                )
            }
        },
    )
}