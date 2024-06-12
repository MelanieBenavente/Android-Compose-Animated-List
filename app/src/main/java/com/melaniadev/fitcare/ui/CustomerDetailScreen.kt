package com.melaniadev.fitcare.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.melaniadev.fitcare.R
import com.melaniadev.fitcare.ui.components.TopBarBackButton

val mockedCustomer = Customer(
    "Mel", null, null, "Dr.Mathews", "Female", "32", "42", "lavienvert@gmail.com", "635239635"
)

@Composable
fun DetailScreen(navigationController: NavHostController, name: String) {
    Scaffold(topBar = {
        TopBarBackButton(
            navigationController,
            title = stringResource(R.string.user_profile_top_bar_title)
        )
    }, content = { padding ->
        DetailScreenContent(modifier = Modifier.padding(padding), customer = mockedCustomer)
    })
}


@Composable
fun DetailScreenContent(modifier: Modifier, customer: Customer) {
    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = customer.name,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
    }
}

