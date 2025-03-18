package com.example.kotlinknowledge.presentation.home.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinknowledge.R
import com.example.kotlinknowledge.app.theme.AppStyle

@Composable
fun HomeHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = 28.dp,
                bottom = 28.dp,
                start = 31.dp,
                end = 31.dp,
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = "ic_menu",
            tint = Color.Black,
            modifier = Modifier
                .size(20.dp),
        )
        Text(
            "Gemstore",
            style = AppStyle.appFont.bold(20.sp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_notification),
            contentDescription = "ic_notification",
            modifier = Modifier
                .size(26.dp),
        )
    }
}