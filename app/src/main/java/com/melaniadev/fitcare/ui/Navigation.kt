package com.melaniadev.fitcare.ui
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun DetailScreen(navigationController: NavHostController, name: String) {
    Column(modifier = Modifier.fillMaxSize()){
        Text(text = "Hola, soy el detalle de usuario", modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
        Text(text = name, modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
    }
}