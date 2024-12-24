import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun EventInputScreen(onSubmit: (Event) -> Unit) {
    var description by remember { mutableStateOf(TextFieldValue("")) }
    var eventType by remember { mutableStateOf("One-time") }
    var dateTime by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Add New Event", style = MaterialTheme.typography.headlineMedium)

        // Description input
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Event Description") },
            modifier = Modifier.fillMaxWidth()
        )

        // Event type dropdown
        var expanded by remember { mutableStateOf(false) }
        Box {
            OutlinedButton(onClick = { expanded = true }) {
                Text(eventType)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                listOf("One-time", "Irregularly Recurring", "Regularly Recurring").forEach { type ->
                    DropdownMenuItem(
                        text = { Text(type) },
                        onClick = {
                            eventType = type
                            expanded = false
                        }
                    )
                }
            }
        }

        // Date/Time input (simplified)
        OutlinedTextField(
            value = dateTime,
            onValueChange = { dateTime = it },
            label = { Text("Date & Time (e.g., 2024-12-31 18:00)") },
            modifier = Modifier.fillMaxWidth()
        )

        // Submit button
        Button(
            onClick = {
                val event = Event(description.text, eventType, dateTime.text)
                onSubmit(event)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Event")
        }
    }
}

data class Event(val description: String, val type: String, val dateTime: String)
