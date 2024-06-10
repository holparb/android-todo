package com.example.todoapp.ui.components.todo_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.model.ItemPriority
import com.example.todoapp.model.TodoModel

@Composable
fun TodoList(
    todos: List<TodoModel>,
    paddingValues: PaddingValues
) {
    LazyColumn (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = paddingValues
    )
    {
        items(todos) { item: TodoModel ->
            TodoListItem(item)
        }
    }
}

@Preview
@Composable
private fun TodoListPreview() {
    val items: List<TodoModel> = listOf(TodoModel(10, "Title", "Subtitle", ItemPriority.LOW), TodoModel(10, "Title", "Subtitle", ItemPriority.MID), TodoModel(10, "Title", "Subtitle", ItemPriority.HIGH))
    TodoList(items, PaddingValues(16.dp))
}