package com.example.kotlinknowledge.app.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

interface AppFont {
    fun thin(size: TextUnit): TextStyle
    fun light(size: TextUnit): TextStyle
    fun regular(size: TextUnit): TextStyle
    fun medium(size: TextUnit): TextStyle
    fun semiBold(size: TextUnit): TextStyle
    fun bold(size: TextUnit): TextStyle
    fun extraBold(size: TextUnit): TextStyle
}

class PrimaryFont : AppFont {
    override fun thin(size: TextUnit): TextStyle {
        return TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.W200,
            fontSize = size,
        )
    }

    override fun light(size: TextUnit): TextStyle {
        return TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.W300,
            fontSize = size,
        );
    }

    override fun regular(size: TextUnit): TextStyle {
        return TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.W400,
            fontSize = size,
            color = AppStyle.appColor.kTextColorMain
        );
    }

    override fun medium(size: TextUnit): TextStyle {
        return TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.W500,
            fontSize = size,
        );
    }

    override fun semiBold(size: TextUnit): TextStyle {
        return TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.W600,
            fontSize = size,
            color = AppStyle.appColor.kTextColorMain
        )
    }

    override fun bold(size: TextUnit): TextStyle {
        return TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.W700,
            fontSize = size,
            color = AppStyle.appColor.kTextColorMain
        )
    }

    override fun extraBold(size: TextUnit): TextStyle {
        return TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.W800,
            fontSize = size,
        )
    }
}

