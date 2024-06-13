package com.example.todoapp.ui.components.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.model.TodoModel
import com.example.todoapp.ui.components.create_item.CreateTodo

@Composable
fun CreateTodoScreen(
    navController: NavController,
    onAddTodo: (TodoModel) -> Unit
) {
    Scaffold (
        modifier = Modifier.padding(16.dp),
    ) { paddingValues ->
        CreateTodo(navController, { onAddTodo(it) }, paddingValues)
    }
}

@Preview
@Composable
private fun CreateTodoScreenPreview() {
    CreateTodoScreen(rememberNavController(), {})
}