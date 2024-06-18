package com.example.todoapp.viewmodels

import com.example.todoapp.model.ItemPriority
import com.example.todoapp.model.TodoModel

sealed interface TodoEvent {
    data object SaveTodo: TodoEvent
    data class SetTitle(val title: String): TodoEvent
    data class SetDescription(val description: String): TodoEvent
    data class SetPriority(val priority: ItemPriority): TodoEvent
    data object GetTodos: TodoEvent
    data class DeleteTodo(val todo: TodoModel): TodoEvent
}