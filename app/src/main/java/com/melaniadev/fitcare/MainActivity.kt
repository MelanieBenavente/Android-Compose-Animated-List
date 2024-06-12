package com.melaniadev.fitcare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.melaniadev.fitcare.ui.CustomerListScreen
import com.melaniadev.fitcare.ui.DetailScreen
import com.melaniadev.fitcare.ui.Routes
import com.melaniadev.fitcare.ui.getNavGraph
import com.melaniadev.fitcare.ui.theme.FitCareTheme
import com.melaniadev.fitcare.ui.mockList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //todo enableEdgeToEdge()
        setContent {
            FitCareTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                    
                ) {
                    val navigationController = rememberNavController()
                    NavHost(navController = navigationController, startDestination = Routes.HOME.name){
                       getNavGraph(navigationController)
                    }
                }
            }
        }
    }
}




