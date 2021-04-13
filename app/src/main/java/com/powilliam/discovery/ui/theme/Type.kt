package com.powilliam.discovery.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.powilliam.discovery.R

val light = Font(R.font.mulish_light, FontWeight.W300)
val regular = Font(R.font.mulish_regular, FontWeight.W400)
val medium = Font(R.font.mulish_medium, FontWeight.W500)
val bold = Font(R.font.mulish_bold, FontWeight.W600)

val Mulish = FontFamily(light, regular, medium, bold)

val Typography = Typography(
        defaultFontFamily = Mulish
)