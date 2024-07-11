package com.melaniadev.fitcare.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

enum class Routes {
    HOME, CUSTOMER_DETAIL
}

fun NavGraphBuilder.getNavGraph(navigationController: NavHostController) {
    composable(Routes.HOME.name) {
        CustomerListScreen(
           navigationController
        )
    }
    composable(Routes.CUSTOMER_DETAIL.name + "/{name}") { backStackEntry ->
        DetailCustomerScreen(navigationController, backStackEntry.arguments?.getString("name").orEmpty())
    }
}