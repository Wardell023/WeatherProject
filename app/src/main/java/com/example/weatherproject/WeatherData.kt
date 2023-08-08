package com.example.weatherproject.ui.theme


import com.squareup.moshi.Json
import java.util.Date

data class City(
    val id: Long = 550600,
    val name: String = "Owatonna",
    val zipCode: String = "55060",
    val country: String = "United States",
    val population: Long = 26398,
    val timezone: Int = -18000
)

data class WeatherData(
    val city: City = City(),
    val cnt: Int?,
    @Json(name = "list")
    val forecasts: List<ForecastItem>,
)
data class Temperature(
    val day: Double?,
    val min: Double?,
    val max: Double?,
)
data class WeatherCondition(
    val icon: String
)
data class ForecastItem(
    val dt: Long?,
    val sunrise: Long?,
    val sunset: Long?,
    val temp: Temperature?,
    @Json(name = "feels_like")
    val feelsLike: Temperature?,
    val pressure: Double?,
    val humidity: Double?,
    @Json(name = "weather")
    val weatherConditions: List<WeatherCondition>,

    ) {
    val iconUrl: String
        get() = "https://openweathermap.org/img/wn/${weatherConditions.firstOrNull()?.icon}@2x.png"

    val date: Date?
        get() = dt?.let { Date(it * 1000L)}
    val sunriseTime: Date?
        get() = sunrise?.let {Date(it * 1000L)}
    val sunsetTime: Date?
        get() = sunset?.let {Date(it * 1000L)}
}
