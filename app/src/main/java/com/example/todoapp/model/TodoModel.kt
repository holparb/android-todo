package com.example.todoapp.model

import androidx.compose.ui.graphics.Color

enum class ItemPriority(val color: Color) {
    LOW(Color.Green),
    MID(Color.Yellow),
    HIGH(Color.Red)
}

data class TodoModel(
    val id: Int,
    val title: String,
    val subTitle: String,
    val priority: ItemPriority
)