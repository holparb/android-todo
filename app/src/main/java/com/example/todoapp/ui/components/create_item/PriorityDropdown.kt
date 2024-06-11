package com.example.todoapp.ui.components.create_item

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.example.todoapp.model.ItemPriority

@Composable
fun PriorityItem(priority: ItemPriority) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Canvas(modifier = Modifier.size(size = 16.dp)) {
            drawCircle(color = priority.color)
        }
        Text(
            modifier = Modifier.padding(12.dp),
            text = priority.name,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun PriorityDropdown(
    priority: ItemPriority,
    onPrioritySelected: (ItemPriority) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var parentSize by remember { mutableStateOf(IntSize.Zero) }
    val angle: Float by animateFloatAsState(targetValue = if (expanded) 180f else 0f)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .onGloballyPositioned {
                parentSize = it.size
            }
            .background(MaterialTheme.colorScheme.background)
            .clickable { expanded = true }
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = MaterialTheme.shapes.small
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(
            modifier = Modifier
                .size(16.dp)
                .weight(1f)
        ) {
            drawCircle(color = priority.color)
        }
        Text(
            modifier = Modifier.weight(8f),
            text = priority.name,
            style = MaterialTheme.typography.titleMedium,
        )
        IconButton(
            modifier = Modifier.rotate(degrees = angle).weight(1.5f),
            onClick = { expanded = true }
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = "drop_down_arrow_icon"
            )
        }
        DropdownMenu(
            modifier = Modifier.width(with(LocalDensity.current) { parentSize.width.toDp() }),
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            ItemPriority.entries.forEach { priority ->
                DropdownMenuItem(
                    text = { PriorityItem(priority) },
                    onClick = {
                        expanded = false;
                        onPrioritySelected(priority)
                    }
                )
            }
        }
    }
}

@Composable
@Preview
fun PriorityItemPreview() {
    PriorityItem(priority = ItemPriority.LOW)
}

@Preview
@Composable
private fun PriorityDropdownPreview() {
    PriorityDropdown(priority = ItemPriority.LOW) {}
}