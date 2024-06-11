package com.example.todoapp.ui.components.screens

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.model.TodoModel
import com.example.todoapp.ui.components.create_item.CreateTodo

@Composable
fun CreateTodoScreen() {
    Scaffold (
        modifier = Modifier.padding(16.dp),
    ) { paddingValues ->
        CreateTodo({ onSaveTodo(it) }, paddingValues)
    }
}

fun onSaveTodo(todo: TodoModel) {
    Log.d("CreateTodoScreen", todo.toString());
}

@Preview
@Composable
private fun CreateTodoScreenPreview() {
    CreateTodoScreen()
}