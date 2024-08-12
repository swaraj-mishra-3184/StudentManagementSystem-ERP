package com.lucky.collegemanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.ExperimentalGraphicsApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lucky.collegemanagement.dashboard.DashboardScreen
import com.lucky.collegemanagement.login.LoginScreen
import com.lucky.collegemanagement.profile.ProfileScreen

@ExperimentalComposeUiApi
@ExperimentalGraphicsApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.LOGIN) {
        composable(Routes.LOGIN) {
            LoginScreen(navController = navController)
        }
        composable("${Routes.PROFILE}/{email}") { backStackEntry ->
            val email = backStackEntry.arguments?.getString("email") ?: ""
            ProfileScreen(email = email)
        }
        composable("${Routes.DASHBOARD}/{email}") { backStackEntry ->
            val email = backStackEntry.arguments?.getString("email") ?: ""
            DashboardScreen(navController = navController, userEmail = email)
        }
    }
}

object Routes {
    const val LOGIN = "login"
    const val PROFILE = "profile"
    const val DASHBOARD = "dashboard"
}
