package com.example.todoapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todoapp.model.TodoModel

@Composable
fun MainScreen(navController: NavController) {
    var todos by remember {
        mutableStateOf(listOf<TodoModel>())
    }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Icon")
            }
        },
        modifier = Modifier.padding(16.dp)
    ) { paddingValues ->
        TodoList(todos = todos, paddingValues = paddingValues)
    }
}
