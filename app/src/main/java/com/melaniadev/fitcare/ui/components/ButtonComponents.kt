package com.melaniadev.fitcare.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.melaniadev.fitcare.ui.theme.localCustomColorsPalette
import com.melaniadev.fitcare.ui.theme.primaryBlue
import com.melaniadev.fitcare.ui.theme.secondaryBlue

@Composable
fun ActionButtonsComponent(navigationController: NavHostController) {
    Row(modifier = Modifier.padding(vertical = 10.dp)) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .weight(1f)
                .fillMaxHeight(0.1f)
                .padding(end = 5.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(secondaryBlue),
            contentPadding = PaddingValues()
        ) {
            Text(
                text = "Schedule visit",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.align(Alignment.CenterVertically),
                color = localCustomColorsPalette.current.customButtonTextColor
            )
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .weight(1f)
                .fillMaxHeight(0.1f)
                .padding(start = 5.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(primaryBlue),
            contentPadding = PaddingValues()
        ) {
            Text(
                text = "Send message",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.align(Alignment.CenterVertically),
                color = localCustomColorsPalette.current.customButtonTextColor
            )
        }
    }
}