package com.example.dailyinterestcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dailyinterestcalculator.ui.components.AppHeader
import com.example.dailyinterestcalculator.ui.components.DateSelectionCard
import com.example.dailyinterestcalculator.ui.components.LoanDetailsCard
import com.example.dailyinterestcalculator.ui.components.ResultCard
import com.example.dailyinterestcalculator.ui.theme.DailyInterestCalculatorTheme
import com.example.dailyinterestcalculator.viewmodel.CalculatorViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DailyInterestCalculatorTheme {
                CalculatorScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel = viewModel()) {

    val principal by viewModel.principalAmount.collectAsState()
    val interestRate by viewModel.interestRate.collectAsState()
    val fromDate by viewModel.fromDate.collectAsState()
    val toDate by viewModel.toDate.collectAsState()
    val result by viewModel.result.collectAsState()

    Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
        androidx.compose.foundation.layout.Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            AppHeader()

            LoanDetailsCard(
                principal = principal,
                interestRate = interestRate,
                onPrincipalChange = { viewModel.updatePrincipal(it) },
                onInterestChange = { viewModel.updateInterestRate(it) }
            )

            DateSelectionCard(
                fromDate = fromDate,
                toDate = toDate,
                onFromDateChange = { viewModel.updateFromDate(it) },
                onToDateChange = { viewModel.updateToDate(it) },
                onCalculate = { viewModel.calculateInterest() }
            )

            ResultCard(result = result)
        }
    }
}
