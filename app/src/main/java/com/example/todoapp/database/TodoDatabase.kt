package com.example.todoapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.model.TodoModel

@Database(
    entities = [TodoModel::class],
    version = 1
)

abstract class TodoDatabase: RoomDatabase() {
    abstract val todoDao: TodoDao
}