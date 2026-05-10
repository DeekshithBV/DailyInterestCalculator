package com.example.dailyinterestcalculator.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dailyinterestcalculator.ui.theme.DarkBlue
import com.example.dailyinterestcalculator.ui.theme.Gold
import com.example.dailyinterestcalculator.ui.theme.green

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppHeader() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(DarkBlue)
            .padding(vertical = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "₹",
            color = green,
            fontSize = 32.sp,
            modifier = Modifier
                .background(Gold)
                .padding(horizontal = 24.dp, vertical = 12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "RAJAMMA ENTERPRISES",
            color = Gold,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Daily Interest Calculator",
            color = Color.White,
            fontSize = 18.sp
        )
    }
}
