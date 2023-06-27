package com.example.weatherproject

import androidx.compose.ui.res.painterResource
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherproject.ui.theme.WeatherProjectTheme
import androidx.compose.foundation.Image
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WeatherProjectScreen()
                }
            }
        }
    }
}
@Composable
fun WeatherProjectScreen() {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top){
        WeatherProjectTitle()
        WeatherProjectBox()
        WeatherProjectStats()
        Spacer(modifier =  Modifier.height(16.dp))
        WeatherProjectContext()
    }
}

@Composable
fun WeatherProjectTitle(){
    val tealColor = colorResource(id = R.color.teal_700)
    Surface(modifier = Modifier.fillMaxWidth(), color = tealColor) {
        Text(
            text = "Weather Project",
            modifier = Modifier.padding(1.dp)
        )
    }
}

@Composable
fun WeatherProjectStats() {
    val temp = stringResource(R.string.temperature)
    val feelsLike = stringResource(R.string.feels_like_temp)
    val degreeSymbol = "\u00B0"

    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
        Column(Modifier.weight(1f)) {
            Text(
                text = buildAnnotatedString {
                    append(temp)
                    withStyle(style = SpanStyle(fontSize = 75.sp)) {
                        append(" $degreeSymbol")
                    }
                },
                modifier = Modifier.padding(start = 16.dp),
                fontSize = 75.sp

            )
            Text(
                    text = "$feelsLike $degreeSymbol",
                    modifier = Modifier
                        .size(200.dp, 60.dp)
                        .padding(16.dp),
                    fontSize = 14.sp
            )
        }
        Image(
            painter = painterResource(id = R.drawable.weathericon),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .padding(end = 0.dp)
                .align(Alignment.CenterVertically),
        )
    }
}

@Composable
fun WeatherProjectContext() {
    Column(Modifier.padding(start = 8.dp)){
        val low = stringResource(R.string.low)
        val high = stringResource(R.string.high)
        val temperatureSymbol = "\u00B0"
        val pressure = stringResource(R.string.pressure)
        val humidity = stringResource(R.string.humidity)

        Text(text = "$low $temperatureSymbol")
        Text(text = "$high $temperatureSymbol")
        Text(text = humidity)
        Text(text = pressure)
    }
}

@Composable
fun WeatherProjectBox() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment =  Alignment.TopCenter
    ) {
        Text(
            text = stringResource(id = R.string.location_name),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWeatherProjectApplication() {
    WeatherProjectTheme {
        WeatherProjectScreen()
    }
}
