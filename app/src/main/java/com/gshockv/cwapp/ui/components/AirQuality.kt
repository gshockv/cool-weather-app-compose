package com.gshockv.cwapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gshockv.cwapp.R
import com.gshockv.cwapp.data.AirQualityData
import com.gshockv.cwapp.data.AirQualityItem
import com.gshockv.cwapp.ui.theme.ColorAirQualityIconTitle
import com.gshockv.cwapp.ui.theme.ColorSurface
import com.gshockv.cwapp.ui.theme.ColorTextPrimary
import com.gshockv.cwapp.ui.theme.ColorTextPrimaryVariant
import com.gshockv.cwapp.ui.theme.CoolWeatherAppTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AirQuality(
  modifier: Modifier = Modifier,
  data: List<AirQualityItem> = AirQualityData
) {
  Surface(
    modifier = modifier.fillMaxWidth(),
    shape = RoundedCornerShape(size = 32.dp),
    color = ColorSurface
  ) {
    Column(
      modifier = Modifier.padding(
        vertical = 18.dp,
        horizontal = 24.dp
      ),
      verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
      AirQualityHeader()

      FlowRow(
        modifier = Modifier.fillMaxWidth(),
        maxItemsInEachRow = 3,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        data.onEach { item ->
          AirQualityInfo(
            qualityItem = item,
            modifier = Modifier.weight(weight = 1f)
          )
        }
      }
    }
  }
}

@Composable
private fun AirQualityHeader(
  modifier: Modifier = Modifier
) {
  Row(
    modifier = modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      Icon(
        painter = painterResource(R.drawable.ic_air_quality_header),
        tint = ColorAirQualityIconTitle,
        modifier = Modifier.size(32.dp),
        contentDescription = null
      )
      Text(
        text = "Air Quality",
        style = MaterialTheme.typography.titleMedium.copy(
          fontSize = 18.sp
        )
      )
    }
    RefreshButton()
  }
}

@Composable
private fun RefreshButton(
  modifier: Modifier = Modifier
) {
  Surface(
    color = ColorSurface,
    shape = CircleShape,
    modifier = Modifier
      .size(32.dp)
      .customShadow(
        color = Color.Black,
        alpha = 0.15f,
        shadowRadius = 16.dp,
        borderRadius = 32.dp,
        offsetY = 4.dp
      )
  ) {
    Box(
      modifier = modifier.fillMaxSize(),
      contentAlignment = Alignment.Center
    ) {
      Image(
        painter = painterResource(R.drawable.ic_refresh),
        modifier = Modifier.size(18.dp),
        contentDescription = null
      )
    }
  }
}

@Composable
private fun AirQualityInfo(
  qualityItem: AirQualityItem,
  modifier: Modifier = Modifier
) {
  Row(
    modifier = modifier,
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    Icon(
      painter = painterResource(qualityItem.icon),
      contentDescription = null,
      tint = ColorAirQualityIconTitle,
      modifier = Modifier.size(24.dp)
    )
    Column(
      horizontalAlignment = Alignment.Start
    ) {
      Text(
        text = qualityItem.title,
        style = MaterialTheme.typography.labelSmall,
        color = ColorTextPrimaryVariant
      )
      Text(
        text = qualityItem.value,
        style = MaterialTheme.typography.labelSmall,
        color = ColorTextPrimary
      )
    }
  }
}

@Composable
@Preview(showSystemUi = true)
private fun PreviewAirQuality() {
  CoolWeatherAppTheme {
    Surface(
      color = ColorSurface,
      modifier = Modifier
        .systemBarsPadding()
        .padding(horizontal = 24.dp)
    ) {
      AirQuality()
    }
  }
}
