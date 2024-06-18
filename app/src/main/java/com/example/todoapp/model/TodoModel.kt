package com.example.todoapp.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

enum class ItemPriority(val color: Color) {
    LOW(Color.Green),
    MID(Color.Yellow),
    HIGH(Color.Red)
}

@Entity(tableName = "todo")
data class TodoModel(
    val title: String,
    val description: String,
    val priority: ItemPriority,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)