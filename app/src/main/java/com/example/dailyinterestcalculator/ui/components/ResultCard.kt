package com.example.dailyinterestcalculator.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dailyinterestcalculator.data.model.CalculationResult
import com.example.dailyinterestcalculator.ui.theme.DarkBlue
import com.example.dailyinterestcalculator.ui.theme.Gold

@Composable
fun ResultCard(result: CalculationResult) {
    if (result.totalDays == 0L) return

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .background(DarkBlue)
                .padding(20.dp)
        ) {
            Text(
                text = "Calculation Result",
                color = Gold,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            ResultRow(label = "Total Days", value = "${result.totalDays} days")
            Spacer(modifier = Modifier.height(8.dp))
            ResultRow(label = "Interest Amount", value = "₹ ${"%.2f".format(result.interestAmount)}")
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider(color = Gold, thickness = 1.dp)
            Spacer(modifier = Modifier.height(8.dp))
            ResultRow(
                label = "Total Payable",
                value = "₹ ${"%.2f".format(result.totalPayable)}",
                isBold = true,
                valueColor = Gold
            )
        }
    }
}

@Composable
private fun ResultRow(
    label: String,
    value: String,
    isBold: Boolean = false,
    valueColor: Color = Color.White
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            color = Color.White,
            fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal,
            fontSize = 16.sp
        )
        Text(
            text = value,
            color = valueColor,
            fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal,
            fontSize = 16.sp
        )
    }
}
