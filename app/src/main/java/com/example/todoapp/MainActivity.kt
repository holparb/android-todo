package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todoapp.ui.components.Navigation
import com.example.todoapp.ui.theme.TodoAppTheme
import com.example.todoapp.viewmodels.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = viewModel<TodoViewModel>()
            TodoAppTheme {
                Navigation(viewModel)
            }
        }
    }
}