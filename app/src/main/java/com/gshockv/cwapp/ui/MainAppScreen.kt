package com.gshockv.cwapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gshockv.cwapp.ui.components.ActionBar
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
        .padding(innerPaddings)
        .padding(
          horizontal = 24.dp,
          vertical = 10.dp
        )
    ) {
      ActionBar()
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
