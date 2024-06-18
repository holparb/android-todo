package com.example.todoapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.database.TodoDao
import com.example.todoapp.model.ItemPriority
import com.example.todoapp.model.TodoModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TodoViewModel(
    private val dao: TodoDao
): ViewModel() {
    private val _todos = MutableStateFlow(listOf<TodoModel>())
    private val _state = MutableStateFlow(TodoState())

    val state = combine(_state, _todos) { state, todos ->
        state.copy(todos = todos)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), TodoState())

    fun saveTodo() {
        val title = state.value.title
        val description = state.value.description
        val priority = state.value.priority

        if(title.isBlank()) return

        val todo = TodoModel(title, description, priority)
        viewModelScope.launch {
            dao.upsertTodo(todo)
        }
        _state.update {
            it.copy(
                title = "",
                description = "",
                priority = ItemPriority.LOW
            )
        }
    }

    fun onEvent(event: TodoEvent) {
        when(event) {
            is TodoEvent.GetTodos -> {
                viewModelScope.launch {
                    dao.getTodosOrderedByTitle().collect{ todoList ->
                        _todos.update { todoList }
                    }
                }
            }
            is TodoEvent.SaveTodo -> {
                saveTodo()
            }
            is TodoEvent.SetDescription -> {
                _state.update { it.copy(description = event.description) }
            }
            is TodoEvent.SetPriority -> {
                _state.update { it.copy(priority = event.priority) }
            }
            is TodoEvent.SetTitle -> {
                _state.update { it.copy(title = event.title) }
            }
            is TodoEvent.DeleteTodo -> {
                viewModelScope.launch {
                    dao.deleteTodo(event.todo)
                }
            }
        }
    }
}