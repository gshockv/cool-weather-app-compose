package com.gshockv.cwapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gshockv.cwapp.ui.components.ActionBar
import com.gshockv.cwapp.ui.components.AirQuality
import com.gshockv.cwapp.ui.components.DailyForecast
import com.gshockv.cwapp.ui.components.WeeklyForecast
import com.gshockv.cwapp.ui.theme.ColorBackground
import com.gshockv.cwapp.ui.theme.CoolWeatherAppTheme

@Composable
fun MainAppScreen() {
  Scaffold(
    modifier = Modifier.fillMaxSize(),
    containerColor = ColorBackground
  ) { innerPaddings ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(innerPaddings)
        .padding(
          horizontal = 24.dp,
          vertical = 10.dp
        )
    ) {
      ActionBar()
      Spacer(
        modifier = Modifier.height(12.dp)
      )
      DailyForecast()
      Spacer(
        modifier = Modifier.height(24.dp)
      )
      AirQuality()
      Spacer(
        modifier = Modifier.height(24.dp)
      )
      WeeklyForecast()
    }

  }
}

@Composable
@Preview(showSystemUi = true)
private fun PreviewMainAppScreen() {
  CoolWeatherAppTheme {
    MainAppScreen()
  }
}
