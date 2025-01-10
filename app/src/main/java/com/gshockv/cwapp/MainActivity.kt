package com.gshockv.cwapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.gshockv.cwapp.ui.theme.CoolWeatherAppTheme
import com.gshockv.cwapp.ui.MainAppScreen

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      CoolWeatherAppTheme {
        MainAppScreen()
      }
    }
  }
}
