package com.melaniadev.fitcare.ui

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

enum class Routes {
    HOME, CUSTOMER_DETAIL
}
//test
fun NavGraphBuilder.getNavGraph(navigationController: NavHostController) {
    composable(Routes.HOME.name) {
        CustomerListScreen(
            navigationController
        )
    }
    composable(
        Routes.CUSTOMER_DETAIL.name + "/{name}",
        enterTransition = {
            fadeIn(
                animationSpec = tween(
                    300, easing = LinearEasing
                )
            ) + slideIntoContainer(
                animationSpec = tween(300, easing = EaseIn),
                towards = AnimatedContentTransitionScope.SlideDirection.Start
            )
        },
        exitTransition = {
            fadeOut(
                animationSpec = tween(
                    300, easing = LinearEasing
                )
            ) + slideOutOfContainer(
                animationSpec = tween(300, easing = EaseOut),
                towards = AnimatedContentTransitionScope.SlideDirection.End
            )
        }
    ) { backStackEntry ->
        DetailCustomerScreen(
            navigationController,
            backStackEntry.arguments?.getString("name").orEmpty()
        )
    }
}