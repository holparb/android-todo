package com.example.todoapp.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MainScreen ) {
        composable<MainScreen> {
            MainScreen(navController = navController)
        }
        composable<CreateTodo> {
            CreateTodo()
        }
    }
}

@Serializable
object MainScreen

@Serializable
object CreateTodo