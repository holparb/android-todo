package com.example.todoapp.ui.components.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todoapp.ui.components.CreateTodoScreen
import com.example.todoapp.ui.components.todo_list.TodoList

@Composable
fun MainScreen(navController: NavController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(CreateTodoScreen) },
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Icon")
            }
        },
        modifier = Modifier.padding(16.dp)
    ) { paddingValues ->
        TodoList(todos = listOf(), paddingValues = paddingValues)
    }
}
