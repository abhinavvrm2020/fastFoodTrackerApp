package com.example.fastfoodtracker.viewmodel

import androidx.lifecycle.ViewModel
import com.example.fastfoodtracker.data.FastFoodUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class FastFoodViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(FastFoodUiState(dateList = dateList()))
    val uiState: StateFlow<FastFoodUiState> = _uiState.asStateFlow();

    val calorieValues = mapOf(
        "Burger" to 250f,
        "Chicken" to 300f,
        "Pizza" to 150f
    )

    fun setQuantityAndCalories(selectedQuantity: Map<String, Float>) {
        var totalCalories = 0f
        var foodQuantity = 0f
        selectedQuantity.forEach { (dish, quantity) ->
            totalCalories += (quantity * (calorieValues[dish] ?: 0f))
            foodQuantity += quantity
        }

        selectedQuantity.entries.forEach { item ->
            _uiState.update { currentState ->
                currentState.copy(
                    food = item.key,
                    quantity = foodQuantity,
                    calories = totalCalories
                )
            }
        }
    }

    fun setDate(selectedDate: String) {
        _uiState.update { currentState ->
            currentState.copy(date = selectedDate)
        }
    }

    fun resetDetails() {
        _uiState.value = FastFoodUiState(dateList = dateList())
    }

    private fun dateList(): List<String> {
        val dateOptions = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()
        // add current date and the following 3 dates.
        repeat(4) {
            dateOptions.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return dateOptions
    }
}
