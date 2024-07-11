package com.melaniadev.fitcare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.melaniadev.fitcare.ui.Routes
import com.melaniadev.fitcare.ui.getNavGraph
import com.melaniadev.fitcare.ui.theme.FitCareTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //todo enableEdgeToEdge()
        setContent {
            FitCareTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White

                ) {
                    val navigationController = rememberNavController()

                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.HOME.name,
                        enterTransition = { EnterTransition.None },
                        exitTransition = { ExitTransition.None }
                    ) {
                        getNavGraph(navigationController)
                    }
                }
            }
        }
    }
}




