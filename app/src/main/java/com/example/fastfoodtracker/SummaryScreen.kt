package com.example.fastfoodtracker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.fastfoodtracker.data.FastFoodUiState

@Composable
fun SummaryScreen(
    fastFoodUiState: FastFoodUiState,
) {
    val summary = stringResource(
        R.string.order_details,
        fastFoodUiState.quantity,
        fastFoodUiState.calories,
        fastFoodUiState.date
    )
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(summary)
    }
}