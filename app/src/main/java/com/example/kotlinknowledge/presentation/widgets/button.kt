package com.example.kotlinknowledge.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinknowledge.app.theme.AppStyle

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
){
    Box(
        modifier = modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(AppStyle.appColor.kSecondary, shape = RoundedCornerShape(24.dp))
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ){
        Text(text, style = AppStyle.appFont.bold(16.sp).copy(
            color = Color.White
        ))
    }
}