package com.example.fastfoodtracker.data

data class FastFoodUiState(
    val date: String = "",
    val food: String = "",
    val quantity: Float = 0f,
    val calories: Float = 0f,
    val dateList: List<String> = listOf()
)