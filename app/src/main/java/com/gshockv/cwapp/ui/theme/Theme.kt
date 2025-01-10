package com.gshockv.cwapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val ColorScheme = darkColorScheme(
  primary = Purple80,
  secondary = PurpleGrey80,
  tertiary = Pink80
)

@Composable
fun CoolWeatherAppTheme(
  content: @Composable () -> Unit
) {
  MaterialTheme(
    colorScheme = ColorScheme,
    typography = Typography,
    content = content
  )
}