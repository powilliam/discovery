package com.powilliam.discovery.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val colors = darkColors(
    primary = Primary,
    onPrimary = OnPrimary,
    surface = Surface,
    onSurface = OnSurface,
    background = Background,
    onBackground = OnBackground
)

@Composable
fun DiscoveryTheme(content: @Composable() () -> Unit) {
    MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
    )
}