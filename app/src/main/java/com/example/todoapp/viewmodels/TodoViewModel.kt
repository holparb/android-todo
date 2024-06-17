package com.example.todoapp.viewmodels

import androidx.lifecycle.ViewModel
import com.example.todoapp.model.TodoModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class TodoState(
    val todos: List<TodoModel> = listOf()
)

class TodoViewModel: ViewModel() {
    private val _state = MutableStateFlow(TodoState())
    val state: StateFlow<TodoState> = _state.asStateFlow()

    fun addTodo(todo: TodoModel) {
        _state.update { currentState ->
            currentState.copy(todos = currentState.todos.plus(todo))
        }
    }

    fun removeTodo(todo: TodoModel) {
        _state.update { currentState ->
            currentState.copy(todos = currentState.todos.minus(todo))
        }
    }
}