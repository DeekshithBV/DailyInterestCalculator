package com.example.dailyinterestcalculator.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dailyinterestcalculator.ui.theme.BorderColor

@Composable
fun LoanDetailsCard(
    principal: String,
    interestRate: String,
    onPrincipalChange: (String) -> Unit,
    onInterestChange: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(20.dp)
    ) {

        Column(modifier = Modifier.padding(16.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {

                Text(
                    text = "Loan Details",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = principal,
                    onValueChange = onPrincipalChange,
                    label = { Text("Principal Amount") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = interestRate,
                    onValueChange = onInterestChange,
                    label = { Text("Interest Rate % / month") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
