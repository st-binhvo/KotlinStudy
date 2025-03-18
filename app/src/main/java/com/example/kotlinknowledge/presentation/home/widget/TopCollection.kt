package com.example.kotlinknowledge.presentation.home.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinknowledge.R
import com.example.kotlinknowledge.app.theme.AppStyle

@Composable
fun TopCollection() {
    Column {
        Row(
            modifier = Modifier
                .padding(AppStyle.appPadding.xxsm)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Top Collection",
                style = AppStyle.appFont.bold(20.sp),
            )
            Text(
                text = "Show all",
                style = AppStyle.appFont.regular(14.sp),
            )
        }
        SlimStyle()
        SexyStyle()
        ClassicStyle()
    }
}

@Composable
fun SlimStyle() {
    Box(
        modifier = Modifier
            .padding(start = AppStyle.appPadding.xxsm,end = AppStyle.appPadding.xxsm)
            .fillMaxWidth()
            .height(141.dp)
            .clip(RoundedCornerShape(AppStyle.appPadding.xxsm))
            .background(color = AppStyle.appColor.kGreyBackground),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            ) {
                Column(
                    modifier = Modifier.padding(start = 33.dp)
                ) {
                    Text(
                        "Sale up to 40%",
                        style = AppStyle.appFont.regular(12.sp).copy(
                            color = AppStyle.appColor.kGrey
                        ),
                    )
                    Box(modifier = Modifier.padding(top = 24.dp))
                    Text(
                        "FOR SLIM\n" +
                                "& BEAUTY",
                        style = AppStyle.appFont.regular(20.sp).copy(
                            color = AppStyle.appColor.kGrey
                        ),
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.style_slim),
                contentDescription = "style_slim",
                modifier = Modifier
                    .size(width = 129.dp, height = 141.dp),
                contentScale = ContentScale.FillHeight
            )
        }
    }
}

@Composable
fun SexyStyle() {
    Box(
        modifier = Modifier
            .padding(AppStyle.appPadding.xxsm)
            .fillMaxWidth()
            .height(210.dp)
            .clip(RoundedCornerShape(AppStyle.appPadding.xxsm))
            .background(color = AppStyle.appColor.kGreyBackground),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            ) {
                Column(
                    modifier = Modifier.padding(start = 33.dp)
                ) {
                    Text(
                        "Summer Collection 2021",
                        style = AppStyle.appFont.regular(12.sp).copy(
                            color = AppStyle.appColor.kGrey
                        ),
                    )
                    Box(modifier = Modifier.padding(top = 24.dp))
                    Text(
                        "Most sexy\n" +
                                "& fabulous\n" +
                                "design",
                        style = AppStyle.appFont.regular(20.sp),
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.style_sexy),
                contentDescription = "style_sexy",
                modifier = Modifier
                    .size(width = 152.dp, height = 210.dp),
                contentScale = ContentScale.FillHeight
            )
        }
    }
}

@Composable
fun ClassicStyle() {
    Row(
        modifier = Modifier.padding(
            start = AppStyle.appPadding.xxsm,
            end = AppStyle.appPadding.xxsm,
            bottom = AppStyle.appPadding.xxsm,
        )
    ) {
        Box(
            modifier = Modifier
                .weight(1f).wrapContentWidth(Alignment.Start)
                .height(194.dp)
                .clip(RoundedCornerShape(AppStyle.appPadding.xxsm))
                .background(color = AppStyle.appColor.kGreyBackground),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.style_ofice),
                    contentDescription = "style_ofice",
                    modifier = Modifier
                        .size(width = 70.dp, height = 194.dp),
                    contentScale = ContentScale.FillHeight
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(Alignment.Start)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 33.dp)
                    ) {
                        Text(
                            "T-Shirts",
                            style = AppStyle.appFont.regular(12.sp).copy(
                                color = AppStyle.appColor.kGrey
                            ),
                        )
                        Box(modifier = Modifier.padding(top = 24.dp))
                        Text(
                            "The\n" +
                                    "Office\n" +
                                    "Life",
                            style = AppStyle.appFont.regular(20.sp),
                        )
                    }
                }
            }
        }
        Box(modifier = Modifier.width(8.dp))
        Box(
            modifier = Modifier
                .weight(1f).wrapContentWidth(Alignment.Start)
                .height(194.dp)
                .clip(RoundedCornerShape(AppStyle.appPadding.xxsm))
                .background(color = AppStyle.appColor.kGreyBackground),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(Alignment.Start)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 33.dp)
                    ) {
                        Text(
                            "Dresses",
                            style = AppStyle.appFont.regular(12.sp).copy(
                                color = AppStyle.appColor.kGrey
                            ),
                        )
                        Box(modifier = Modifier.padding(top = 24.dp))
                        Text(
                            "Elegant\n" +
                                    "Design",
                            style = AppStyle.appFont.regular(20.sp),
                        )
                    }
                }
                Image(
                    painter = painterResource(id = R.drawable.style_dress),
                    contentDescription = "style_dress",
                    modifier = Modifier
                        .size(width = 70.dp, height = 194.dp),
                    contentScale = ContentScale.FillHeight
                )
            }
        }
    }
}
