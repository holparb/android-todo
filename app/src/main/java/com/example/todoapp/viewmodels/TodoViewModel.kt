package com.example.todoapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.todoapp.model.TodoModel

class TodoViewModel: ViewModel() {
    var _todos by mutableStateOf(listOf<TodoModel>())
        private set

    fun addTodo(todo: TodoModel) {
        _todos = _todos.plus(todo)
    }
}