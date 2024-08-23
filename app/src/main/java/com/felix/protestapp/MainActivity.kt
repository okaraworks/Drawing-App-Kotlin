@file:OptIn(ExperimentalMaterial3Api::class)

package com.felix.protestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.felix.protestapp.ui.theme.ProtestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProtestAppTheme {
                // Get ViewModel from the Factory
                val viewModel: ProtesterViewModel = viewModel(
                    factory = ProtesterViewModelFactory((application as MyApplication).repository)
                )
                // Display the main screen
                ProtesterScreen(viewModel)
            }
        }
    }
}

@Composable
fun ProtesterScreen(viewModel: ProtesterViewModel) {
    val protesters by viewModel.allProtesters.observeAsState(listOf())
    var showDialog by remember { mutableStateOf(false) }

    // Show the dialog for adding a new protester
    if (showDialog) {
        AddProtesterDialog(
            onDismissRequest = { showDialog = false },
            onAddProtester = { location, description, date, time, message ->
                if (location.isNotBlank() && description.isNotBlank() && date.isNotBlank() && time.isNotBlank() && message.isNotBlank()) {
                    viewModel.insert(Protester(location = location, description = description, date = date, time = time, message = message))
                }
                showDialog = false
            }
        )
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        // Display List of Protesters
        LazyColumn {
            items(protesters) { protester ->
                ProtesterItem(protester)
            }
        }

        Spacer(modifier = Modifier.weight(1f)) // Push FAB to the bottom

        // Floating Action Button
        FloatingActionButton(
            onClick = { showDialog = true },
            modifier = Modifier
                .align(Alignment.End)
                .padding(16.dp)
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add Protester")
        }
    }
}

@Composable
fun AddProtesterDialog(
    onDismissRequest: () -> Unit,
    onAddProtester: (String, String, String, String, String) -> Unit
) {
    var location by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text("Add New Protester") },
        text = {
            Column {
                TextField(
                    value = location,
                    onValueChange = { location = it },
                    label = { Text("Location") }
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") }
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = date,
                    onValueChange = { date = it },
                    label = { Text("Date") }
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = time,
                    onValueChange = { time = it },
                    label = { Text("Time") }
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = message,
                    onValueChange = { message = it },
                    label = { Text("Message") }
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    onAddProtester(location, description, date, time, message)
                }
            ) {
                Text("Add")
            }
        },
        dismissButton = {
            Button(onClick = onDismissRequest) {
                Text("Cancel")
            }
        }
    )
}

@Composable
fun ProtesterItem(protester: Protester) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Location: ${protester.location}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Description: ${protester.description}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Date: ${protester.date}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Time: ${protester.time}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Message: ${protester.message}", style = MaterialTheme.typography.bodySmall)
        }
    }
}
