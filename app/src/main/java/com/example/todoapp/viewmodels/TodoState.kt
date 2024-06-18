package com.example.todoapp.viewmodels

import com.example.todoapp.model.ItemPriority
import com.example.todoapp.model.TodoModel

data class TodoState(
    val todos: List<TodoModel> = listOf(),
    val title: String = "",
    val description: String = "",
    val priority: ItemPriority = ItemPriority.LOW
)