package com.example.kotlinknowledge.presentation.discover.widget

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.kotlinknowledge.R
import com.example.kotlinknowledge.app.config.model.ScreenRoute
import com.example.kotlinknowledge.app.theme.AppStyle

@Composable
fun DiscoveryHeader(modifier: Modifier = Modifier,) {
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
            "Discover",
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

@Composable
fun SearchHeader(goToSearchScreen: ()-> Unit) {
    Row(
        modifier = Modifier.padding(
            horizontal = AppStyle.appPadding.xxsm,
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val textData by remember {
            mutableStateOf("")
        }

        TextField(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 5.dp)
                .shadow(
                    elevation = 4.dp,
                    ambientColor = AppStyle.appColor.kGrey,
                    spotColor = AppStyle.appColor.kGrey,
                    shape = RoundedCornerShape(20.dp)
                )
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp)),
            readOnly = true,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = AppStyle.appColor.kDeepWhite,
                focusedContainerColor = AppStyle.appColor.kDeepWhite,
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                focusedTextColor = Color.Black,
            ),
            value = textData,
            onValueChange = {},
            placeholder = { Text(
                "Search",
                style = AppStyle.appFont.medium(14.sp),
                ) },
            prefix = {
                Icon(
                    Icons.Rounded.Search,
                    contentDescription = "ic_search"
                )
            }
        )
        Spacer(modifier = Modifier.padding(horizontal = AppStyle.appPadding.xsl))
        Box(
            modifier = Modifier
                .size(55.dp)
                .shadow(
                    elevation = 4.dp,
                    ambientColor = AppStyle.appColor.kGrey,
                    spotColor = AppStyle.appColor.kGrey,
                    shape = RoundedCornerShape(15.dp)
                )
                .background(color = AppStyle.appColor.kDeepWhite)
                .clip(RoundedCornerShape(15.dp))
                .clickable {
                    goToSearchScreen()
                },
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_filter),
                contentDescription = "ic_filter",
                modifier = Modifier.size(27.dp)
            )
        }
    }
}