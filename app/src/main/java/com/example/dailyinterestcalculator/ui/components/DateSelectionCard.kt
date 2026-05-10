package com.example.dailyinterestcalculator.ui.components

import android.app.DatePickerDialog
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dailyinterestcalculator.ui.theme.DarkBlue
import com.example.dailyinterestcalculator.ui.theme.Gold
import com.example.dailyinterestcalculator.utils.DateUtils
import java.util.Calendar

@Composable
fun DateSelectionCard(
    fromDate: Long,
    toDate: Long,
    onFromDateChange: (Long) -> Unit,
    onToDateChange: (Long) -> Unit,
    onCalculate: () -> Unit
) {
    val context = LocalContext.current

    fun showDatePicker(initialMillis: Long, onDateSelected: (Long) -> Unit) {
        val cal = Calendar.getInstance().apply { timeInMillis = initialMillis }
        DatePickerDialog(
            context,
            { _, year, month, day ->
                val selected = Calendar.getInstance().apply {
                    set(year, month, day, 0, 0, 0)
                    set(Calendar.MILLISECOND, 0)
                }
                onDateSelected(selected.timeInMillis)
            },
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = "Select Date Range",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = DateUtils.formatDate(fromDate),
                onValueChange = {},
                readOnly = true,
                label = { Text("From Date") },
                modifier = Modifier
                    .fillMaxWidth(),
                trailingIcon = {
                    androidx.compose.material3.TextButton(onClick = {
                        showDatePicker(fromDate, onFromDateChange)
                    }) { Text("Pick") }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = DateUtils.formatDate(toDate),
                onValueChange = {},
                readOnly = true,
                label = { Text("To Date") },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    androidx.compose.material3.TextButton(onClick = {
                        showDatePicker(toDate, onToDateChange)
                    }) { Text("Pick") }
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = onCalculate,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = DarkBlue,
                    contentColor = Gold
                )
            ) {
                Text(
                    text = "CALCULATE",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }
    }
}
