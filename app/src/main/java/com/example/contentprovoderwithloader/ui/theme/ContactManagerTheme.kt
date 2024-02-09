package com.example.contentprovoderwithloader.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun ContactManagerTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        content = content,
        colorScheme = ColorScheme(
            primary = Color.Blue,
            secondary = Color.Blue,
            error = Color.Red,
            surface = Color.White,
            onPrimary = Color.White,
            onSecondary = Color.White,
            onBackground = Color.Black,
            onSurface = Color.Black,
            onError = Color.White, // Provide a color for error text
            onTertiary = Color.Black,
            secondaryContainer = Color.White,
            scrim = Color.White,
            inverseOnSurface = Color.White,
            primaryContainer = Color.White,
            surfaceTint = Color.White,
            errorContainer = Color.White,
            inverseSurface = Color.White,
            outline = Color.White,
            onPrimaryContainer = Color.White,
            onSurfaceVariant = Color.White,
            surfaceVariant = Color.White,
            tertiary = Color.White,
            background = Color.White,
            tertiaryContainer = Color.White,
            inversePrimary = Color.White,
            outlineVariant = Color.White,
            onTertiaryContainer = Color.White,
            onErrorContainer = Color.White,
            onSecondaryContainer = Color.White
        )
    )
}


