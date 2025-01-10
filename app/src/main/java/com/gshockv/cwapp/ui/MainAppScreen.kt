package com.gshockv.cwapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.gshockv.cwapp.ui.theme.CoolWeatherAppTheme

@Composable
fun MainAppScreen(
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .fillMaxSize()
      .systemBarsPadding(),
    verticalArrangement = Arrangement.Center
  ) {
    Text(
      text = "Cool Weather App",
      modifier = Modifier.fillMaxWidth(),
      textAlign = TextAlign.Center,
      style = MaterialTheme.typography.headlineMedium,
      color = Color(0xFF336699),
      fontWeight = FontWeight.Light
    )
  }
}

@Composable
@Preview(showSystemUi = true)
private fun PreviewMainAppScreen() {
  CoolWeatherAppTheme {
    MainAppScreen()
  }
}
