package com.example.weatherproject


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


data class DayForecast(
    val day: String,
    val forecastTemperature: ForecastTemp,
    val sunrise: String,
    val sunset: String)

data class ForecastTemp(
    val minTemp: Double,
    val maxTemp: Double)


@Composable
fun ForecastScreen() {
    val forecastItems = listOf(
        DayForecast("June 5", ForecastTemp(12.5, 5.8), "5:42 AM", "7:25 PM"),
        DayForecast("June 6", ForecastTemp(19.0, 26.8), "5:29 AM", "6:45 PM"),
        DayForecast("June 7", ForecastTemp(22.6, 40.7), "6:34 AM", "7:55 PM"),
        DayForecast("June 8", ForecastTemp(4.5, 20.0), "5:28 AM", "7:23 PM"),
        DayForecast("June 9", ForecastTemp(66.7, 54.2), "6:45 AM", "6:30 PM"),
        DayForecast("June 10", ForecastTemp(34.6, 12.5), "6:55 AM", "6:47 PM"),
        DayForecast("June 11", ForecastTemp(29.0, 16.7), "5:45 AM", "6:29 PM"),
        DayForecast("June 12", ForecastTemp(30.0, 29.3), "5:30 AM", "6:52 PM"),
        DayForecast("June 13", ForecastTemp(21.5, 45.7), "5:28 AM", "6:59 PM"),
        DayForecast("June 14", ForecastTemp(10.2, 34.6), "6:22 AM", "7:00 PM"),
        DayForecast("June 15", ForecastTemp(72.1, 5.8), "6:42 AM", "7:25 PM"),
        DayForecast("June 16", ForecastTemp(25.2, 12.9), "5:20 AM", "7:18 PM"),
        DayForecast("June 17", ForecastTemp(38.3, 8.8), "6:22 AM", "6:27 PM"),
        DayForecast("June 18", ForecastTemp(26.6, 30.6), "6:05 AM", "6:41 PM"),
        DayForecast("June 19", ForecastTemp(13.9, 33.3), "5:26 AM", "7:50 PM"),
        DayForecast("June 20", ForecastTemp(40.7, 22.2), "6:37 AM", "7:25 PM"),
    )
    Column {
        forecastItems.forEach { forecast ->
            ForecastRow(forecast)
        }
    }
}

@Composable
fun ForecastRow(dayForecast: DayForecast) {
    Row(modifier = Modifier.padding(16.dp)) {

        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Row(modifier = Modifier.padding(16.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.weathericon),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = "${dayForecast.day}")
                    Text(text = "Temp: ${dayForecast.forecastTemperature.maxTemp}°F")
                    Text(text = "Sunrise: ${dayForecast.sunrise}")
                    Text(text = "High: ${dayForecast.forecastTemperature.maxTemp}°F Low: ${dayForecast.forecastTemperature.minTemp}°F")
                    Text(text = "Sunset: ${dayForecast.sunset}")
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewForecastScreen() {
    ForecastScreen()
}