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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherproject.ui.theme.WeatherProjectTheme
import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherProjectTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "main"){
                    composable("main"){ WeatherProjectScreen(navController) }
                    composable("forecast") { ForecastScreen() }
                }
                 //Surface(
                   // modifier = Modifier.fillMaxSize(),
                   // color = MaterialTheme.colorScheme.background
               // ) {
                  //  WeatherProjectScreen()
               // }
            }
        }
    }
}
@Composable
fun WeatherProjectScreen(navController: NavHostController) {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top){
        WeatherProjectTitle("Weather Project")
        WeatherProjectBox()
        WeatherProjectStats()
        Spacer(modifier =  Modifier.height(16.dp))
        WeatherProjectContext()
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { navController.navigate("forecast") },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ){
                Text(
                    text = "Forecast"
                )
        }
        //)
        //ForecastScreen()
    }
}

@Composable
fun WeatherProjectTitle(title: String) {
    val tealColor = colorResource(id = R.color.teal_700)
    Surface(modifier = Modifier.fillMaxWidth(), color = tealColor) {
        Text(
            text = title,
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
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "main") {
                composable("main") { WeatherProjectScreen(navController) }
                composable("forecast") { ForecastScreen() }
            }
        }

    }


