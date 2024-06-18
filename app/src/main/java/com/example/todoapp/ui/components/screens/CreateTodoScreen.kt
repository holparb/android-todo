package com.example.todoapp.ui.components.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.ui.components.create_item.CreateTodo
import com.example.todoapp.viewmodels.TodoEvent
import com.example.todoapp.viewmodels.TodoState

@Composable
fun CreateTodoScreen(
    navController: NavController,
    state: TodoState,
    onEvent: (TodoEvent) -> Unit
) {
    Scaffold (
        modifier = Modifier.padding(16.dp),
    ) { paddingValues ->
        CreateTodo(
            navController = navController,
            state = state,
            onEvent = onEvent,
            paddingValues = paddingValues
        )
    }
}

@Preview
@Composable
private fun CreateTodoScreenPreview() {
    CreateTodoScreen(rememberNavController(), TodoState(), {})
}