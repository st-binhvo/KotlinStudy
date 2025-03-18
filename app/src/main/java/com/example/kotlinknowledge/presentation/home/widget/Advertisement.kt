package com.example.kotlinknowledge.presentation.home.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.example.kotlinknowledge.presentation.home.viewmodel.HomeViewModel

@Composable
fun Advertisement() {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://fastly.picsum.photos/id/10/2500/1667.jpg?hmac=J04WWC_ebchx3WwzbM-Z4_KC_LeLBWr5LZMaAkWkF68")
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.height(158.dp).padding(vertical = 18.dp)
    )
}