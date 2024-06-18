package com.example.todoapp.ui.components.todo_list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.todoapp.model.ItemPriority
import com.example.todoapp.model.TodoModel
import com.example.todoapp.ui.theme.TodoAppTheme
import com.example.todoapp.viewmodels.TodoEvent

@Composable
fun TodoListItem(
    item : TodoModel,
    onEvent: (TodoEvent) -> Unit
) {
    Card (
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(16),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 0.dp, end = 12.dp, top = 12.dp, bottom = 12.dp)
        ) {
            Canvas(
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
                    .weight(2f)
            ) {
                drawCircle(
                    color = item.priority.color,
                    radius = size.minDimension / 4
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4f)
            ) {
                Text(text = item.title)
                Text(text = item.description)
            }
            Spacer(modifier = Modifier.width(12.dp))
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = { onEvent(TodoEvent.DeleteTodo(item)) }
            ) {
                Icon(Icons.Default.Delete, "Delete")
            }
        }
    }
}

class PriorityParameterProvider: PreviewParameterProvider<ItemPriority> {
    override val values: Sequence<ItemPriority>
        get() = sequenceOf(ItemPriority.LOW, ItemPriority.MID, ItemPriority.HIGH)
}

@Preview
@Composable
private fun TodoItemPreview(
    @PreviewParameter(provider = PriorityParameterProvider::class) priority: ItemPriority
) {
    TodoAppTheme {
        TodoListItem(TodoModel(id = 10, title = "Title", description = "SubTitle", priority = priority), {})
    }
}