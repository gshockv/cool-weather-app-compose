package com.gshockv.cwapp.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gshockv.cwapp.R
import com.gshockv.cwapp.data.ForecastData
import com.gshockv.cwapp.data.ForecastItem
import com.gshockv.cwapp.ui.theme.ColorGradient1
import com.gshockv.cwapp.ui.theme.ColorGradient2
import com.gshockv.cwapp.ui.theme.ColorGradient3
import com.gshockv.cwapp.ui.theme.ColorTextAction
import com.gshockv.cwapp.ui.theme.ColorTextPrimary
import com.gshockv.cwapp.ui.theme.ColorTextPrimaryVariant
import com.gshockv.cwapp.ui.theme.ColorTextSecondary
import com.gshockv.cwapp.ui.theme.ColorTextSecondaryVariant
import com.gshockv.cwapp.ui.theme.CoolWeatherAppTheme
import com.gshockv.cwapp.ui.util.fromHex

@Composable
fun WeeklyForecast(
  data: List<ForecastItem> = ForecastData,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier,
    verticalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    WeatherForecastHeader()

    LazyRow(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
      items(
        items = data,
        key = { it.dayOfWeek }
      ) {
        ForecastInfo(
          forecastItem = it
        )
      }
    }
  }
}

@Composable
private fun WeatherForecastHeader(
  modifier: Modifier = Modifier
) {
  Row(
    modifier = modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    Text(
      text = "Weekly Forecast",
      style = MaterialTheme.typography.titleLarge,
      color = ColorTextPrimary,
      fontWeight = FontWeight.Bold,
      fontSize = 20.sp
    )
    ActionText()
  }
}

@Composable
private fun ActionText(
  modifier: Modifier = Modifier
) {
  Row(
    modifier = modifier,
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(2.dp)
  ) {
    Text(
      text = "Next month",
      style = MaterialTheme.typography.titleSmall,
      color = ColorTextAction,
      fontWeight = FontWeight.Medium
    )
    Icon(
      painter = painterResource(R.drawable.ic_arrow_right),
      tint = ColorTextAction,
      modifier = Modifier.size(20.dp),
      contentDescription = null
    )
  }
}

@Composable
private fun ForecastInfo(
  forecastItem: ForecastItem,
  modifier: Modifier = Modifier
) {

  val updatedModifier = remember(forecastItem.isSelected) {
    if (forecastItem.isSelected) {
      modifier.background(
        shape = RoundedCornerShape(percent = 50),
        brush = Brush.linearGradient(
          0f to ColorGradient1,
          0.5f to ColorGradient2,
          1f to ColorGradient3
        )
      )
    } else {
      modifier
    }
  }

  val dayOfWeekTextColor = remember(forecastItem.isSelected) {
    if (forecastItem.isSelected) ColorTextSecondary else ColorTextPrimary
  }

  val dateTextColor = remember(forecastItem.isSelected) {
    if (forecastItem.isSelected) ColorTextSecondaryVariant else ColorTextPrimaryVariant
  }

  val temperatureTextStyle = remember(forecastItem.isSelected) {
    if (forecastItem.isSelected) {
      TextStyle(
        brush = Brush.verticalGradient(
          0f to Color.White,
          1f to Color.White.copy(alpha = 0.3f)
        ),
        fontSize = 24.sp,
        fontWeight = FontWeight.Black
      )
    } else {
      TextStyle(
        color = ColorTextPrimary,
        fontSize = 24.sp,
        fontWeight = FontWeight.Black
      )
    }
  }

  Column(
    modifier = updatedModifier
      .width(65.dp)
      .padding(
        horizontal = 10.dp,
        vertical = 16.dp
      ),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      text = forecastItem.dayOfWeek,
      style = MaterialTheme.typography.labelLarge,
      color = dayOfWeekTextColor
    )
    Text(
      text = forecastItem.date,
      style = MaterialTheme.typography.labelMedium,
      fontWeight = FontWeight.Normal,
      color = dateTextColor
    )
    Spacer(
      modifier = Modifier.height(8.dp)
    )
    WeatherImage(
      image = forecastItem.image
    )
    Spacer(
      modifier = Modifier.height(6.dp)
    )
    Text(
      text = forecastItem.temperature,
      style = temperatureTextStyle
    )
    Spacer(
      modifier = Modifier.height(8.dp)
    )
    AirQualityIndicator(
      value = forecastItem.airQuality,
      color = forecastItem.airQualityIndicatorColorHex
    )
  }
}

@Composable
private fun WeatherImage(
  @DrawableRes image: Int,
  modifier: Modifier = Modifier
) {
  Box(
    modifier = modifier
      .fillMaxWidth()
      .height(60.dp),
    contentAlignment = Alignment.Center
  ) {
    Image(
      painter = painterResource(image),
      contentDescription = null,
      contentScale = ContentScale.FillWidth,
      modifier = Modifier.fillMaxWidth()
    )
  }
}

@Composable
private fun AirQualityIndicator(
  value: String,
  color: String,
  modifier: Modifier = Modifier
) {
  Surface(
    modifier = modifier,
    color = Color.fromHex(color),
    contentColor = ColorTextSecondary,
    shape = RoundedCornerShape(size = 8.dp)
  ) {
    Box(
      modifier = Modifier
        .width(35.dp)
        .padding(vertical = 2.dp),
      contentAlignment = Alignment.Center
    ) {
      Text(
        text = value
      )
    }
  }
}

@Composable
@Preview(showSystemUi = true)
private fun PreviewWeeklyForecast() {
  CoolWeatherAppTheme {
    WeeklyForecast(
      modifier = Modifier.systemBarsPadding()
    )
  }
}
