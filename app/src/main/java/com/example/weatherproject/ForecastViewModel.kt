package com.example.weatherproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherproject.ui.theme.WeatherData
import kotlinx.coroutines.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject



@HiltViewModel
class ForecastViewModel @Inject constructor(private val api: ApiService) : ViewModel() {

    sealed class ForecastState {
        object Loading : ForecastState()
        data class Success(val forecastData: WeatherData) : ForecastState()
        data class Error(val error: String) : ForecastState()
    }

    private val _forecastData: MutableLiveData<WeatherData> = MutableLiveData()
    val forecastData: LiveData<WeatherData> get() = _forecastData

    private val _forecastState = MutableLiveData<ForecastState>(ForecastState.Loading)
    val forecastState: LiveData<ForecastState>get() = _forecastState

    fun getForecastData(zipCode: String, cnt: Int) = viewModelScope.launch{
        _forecastState.value = ForecastState.Loading
        try {
            _forecastData.value = api.getForecastData(zipCode, cnt)
            _forecastState.value =
                _forecastData.value?.let {ForecastState.Success(it) }
                ?: ForecastState.Error("An Unknown error occurred")

        } catch (e: Exception){
            _forecastState.value = ForecastState.Error(e.message ?: "An unknown error Occurred")
        }
    }
}