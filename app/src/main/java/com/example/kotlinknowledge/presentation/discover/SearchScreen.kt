package com.example.kotlinknowledge.presentation.discover

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinknowledge.R
import com.example.kotlinknowledge.app.theme.AppStyle
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Color.White,
                drawerShape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)
            ) {
                FilterCompose()
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Navigation Drawer Example") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                if (drawerState.isClosed) {
                                    drawerState.open()
                                } else {
                                    drawerState.close()
                                }
                            }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) { innerPadding ->
            Text(innerPadding.toString())
        }
    }
}

@Preview
@Composable
fun FilterCompose() {
    var priceRange by remember { mutableStateOf(10f..80f) }
    var selectedColor by remember { mutableStateOf(Color.Red) }
    var selectedRating by remember { mutableIntStateOf(0) }
    val discountOptions = listOf("50% off", "40% off", "30% off", "25% off")
    var selectedDiscounts by remember { mutableStateOf(discountOptions.toSet()) }

    Column(modifier = Modifier.padding(16.dp)) {
        Spacer(modifier = Modifier.height(41.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Filter", style = AppStyle.appFont.medium(20.sp))
            Icon(
                painter = painterResource(id = R.drawable.ic_filter),
                contentDescription = "ic_filter",
                modifier = Modifier.size(27.dp)
            )
        }
        HorizontalDivider(
            modifier = Modifier.padding(top = 30.dp, bottom = 24.dp),
            color = AppStyle.appColor.kGreyBackground
        )

        // Price Slider
        Text(text = "Price", style = AppStyle.appFont.medium(20.sp))
        Slider(
            valueRange = 10f..80f,
            value = priceRange.start,
            onValueChange = { start ->
                priceRange = start..priceRange.endInclusive
            },
            onValueChangeFinished = { /* Handle changes if necessary */ }
        )
        Text(
            text = "\$${priceRange.start.toInt()} - \$${priceRange.endInclusive.toInt()}",
            style = AppStyle.appFont.medium(12.sp),
        )
        Spacer(modifier = Modifier.height(41.dp))
        // Color Selection
        Text(text = "Color", style = AppStyle.appFont.medium(20.sp))
        Spacer(modifier = Modifier.height(24.dp))
        Row {
            // Dummy color options
            val colors = listOf(
                Color.Yellow,
                Color.Red,
                Color.Black,
                Color.Gray,
                Color.Green,
                Color.Blue
            )
            colors.forEach { color ->
                Box(modifier = Modifier
                    .padding(end = 12.dp)
                    .size(40.dp)
                    .clip(RoundedCornerShape(percent = 50))
                    .background(color)
                    .clickable {
                        selectedColor = color
                    })
            }
        }

        // Star Rating Selection
        Spacer(modifier = Modifier.height(41.dp))
        Text(text = "Star Rating", style = AppStyle.appFont.medium(20.sp))
        Spacer(modifier = Modifier.height(24.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            (1..5).forEach { rating ->
                Box(
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .size(44.dp)
                        .clip(RoundedCornerShape(percent = 50))
                        .border(
                            width = 2.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(percent = 50)
                        )
                        .background(color = if (rating <= selectedRating) Color.Black else Color.White)
                        .clickable {
                            selectedRating = rating
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "$rating Star",
                            tint = if (rating <= selectedRating) Color.White else Color.Black,
                            modifier = Modifier
                                .size(16.dp)
                        )
                        Text(rating.toString(), style = AppStyle.appFont.medium(13.sp).copy(
                            color = if (rating <= selectedRating) Color.White else Color.Black
                        ))
                    }
                }


            }
        }

        // Category Selection
        Spacer(modifier = Modifier.height(41.dp))
        Text(text = "Category", style = AppStyle.appFont.medium(20.sp))

        // Discount Selection
        Spacer(modifier = Modifier.height(41.dp))
        Text(text = "Discount", style = AppStyle.appFont.medium(20.sp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
        ) {
            items(discountOptions.size){
                Surface(
                    modifier = Modifier
                        .clickable {
                            selectedDiscounts = if (selectedDiscounts.contains(discountOptions[it])) {
                                selectedDiscounts - discountOptions[it]
                            } else {
                                selectedDiscounts + discountOptions[it]
                            }
                        },
                    shape = MaterialTheme.shapes.small,
                    color = if (selectedDiscounts.contains(discountOptions[it])) Color.Gray else Color.White
                )
                {
                    Text(text = discountOptions[it], modifier = Modifier.padding(8.dp))
                }
            }
        }

        // Action Buttons
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { /* Handle Reset */ }) {
                Text("Reset")
            }
            Button(onClick = { /* Handle Apply */ }) {
                Text("Apply", color = Color.White)
            }
        }
    }
}