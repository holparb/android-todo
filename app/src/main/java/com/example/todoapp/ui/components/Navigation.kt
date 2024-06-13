package com.example.todoapp.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.ui.components.screens.MainScreen
import com.example.todoapp.ui.components.screens.CreateTodoScreen
import com.example.todoapp.viewmodels.TodoViewModel
import kotlinx.serialization.Serializable

@Composable
fun Navigation(
    viewModel: TodoViewModel
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MainScreen ) {
        composable<MainScreen> {
            val state by viewModel.state.collectAsState()
            MainScreen(
                navController = navController,
                state = state
            )
        }
        composable<CreateTodoScreen> {
            CreateTodoScreen(
                navController = navController,
                onAddTodo = { viewModel.addTodo(it) }
            )
        }
    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(
    navController: NavHostController
) : T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}

@Serializable
object MainScreen

@Serializable
object CreateTodoScreen