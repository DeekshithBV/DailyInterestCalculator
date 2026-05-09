package com.example.dailyinterestcalculator.viewmodel

import androidx.lifecycle.ViewModel
import com.example.dailyinterestcalculator.data.model.CalculationResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.temporal.ChronoUnit

class CalculatorViewModel : ViewModel() {

    private val _principalAmount = MutableStateFlow("15000")
    val principalAmount: StateFlow<String> = _principalAmount.asStateFlow()

    private val _interestRate = MutableStateFlow("2")
    val interestRate: StateFlow<String> = _interestRate.asStateFlow()

    private val _fromDate = MutableStateFlow(System.currentTimeMillis())
    val fromDate: StateFlow<Long> = _fromDate.asStateFlow()

    private val _toDate = MutableStateFlow(
        System.currentTimeMillis() + (364 * 24 * 60 * 60 * 1000L)
    )
    val toDate: StateFlow<Long> = _toDate.asStateFlow()

    private val _result = MutableStateFlow(CalculationResult())
    val result: StateFlow<CalculationResult> = _result.asStateFlow()

    fun updatePrincipal(value: String) {
        _principalAmount.value = value
    }

    fun updateInterestRate(value: String) {
        _interestRate.value = value
    }

    fun updateFromDate(value: Long) {
        _fromDate.value = value
    }

    fun updateToDate(value: Long) {
        _toDate.value = value
    }

    fun calculateInterest() {

        val principal = _principalAmount.value.toDoubleOrNull() ?: 0.0
        val monthlyRate = _interestRate.value.toDoubleOrNull() ?: 0.0

        val startDate = Instant.ofEpochMilli(_fromDate.value)
            .atZone(ZoneId.systemDefault())
            .toLocalDate()

        val endDate = Instant.ofEpochMilli(_toDate.value)
            .atZone(ZoneId.systemDefault())
            .toLocalDate()

        var days = ChronoUnit.DAYS.between(startDate, endDate)

        if (days <= 0) {
            days = 1
        }

        val interest = (principal * monthlyRate / 100) * (days.toDouble() / 30)

        val total = principal + interest

        _result.value = CalculationResult(
            totalDays = days,
            interestAmount = interest,
            totalPayable = total
        )
    }
}
