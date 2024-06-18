package com.example.todoapp.ui.components.create_item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.ui.components.MainScreen
import com.example.todoapp.viewmodels.TodoEvent
import com.example.todoapp.viewmodels.TodoState

@Composable
fun CreateTodo(
    navController: NavController,
    state: TodoState,
    onEvent: (TodoEvent) -> Unit,
    paddingValues: PaddingValues,
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.title,
            onValueChange = { onEvent(TodoEvent.SetTitle(it)) },
            label = { Text("Title") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        PriorityDropdown(
            priority = state.priority,
            onPrioritySelected = { onEvent(TodoEvent.SetPriority(it)) }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().weight(3f),
            value = state.description,
            onValueChange = { onEvent(TodoEvent.SetDescription(it)) },
            label = { Text("Description") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth().wrapContentHeight(Alignment.Bottom).weight(4f)
        ) {
            FloatingActionButton(
                onClick = {
                    onEvent(TodoEvent.SaveTodo)
                    navController.navigate(MainScreen)
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done"
                )
            }
        }
    }
}

@Preview
@Composable
private fun CreateTodoPreview() {
    CreateTodo(rememberNavController(), TodoState(), {}, paddingValues = PaddingValues(16.dp))
}