package com.example.todoapp.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.ui.components.screens.MainScreen
import com.example.todoapp.ui.components.screens.CreateTodoScreen
import kotlinx.serialization.Serializable

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MainScreen ) {
        composable<MainScreen> {
            MainScreen(navController = navController)
        }
        composable<CreateTodoScreen> {
            CreateTodoScreen()
        }
    }
}

@Serializable
object MainScreen

@Serializable
object CreateTodoScreen