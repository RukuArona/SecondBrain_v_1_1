package com.example.secondbrain_v_1_1

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        // You can add EventInputScreen or other UI here
        EventInputScreen { event ->
            // Handle event submission here
            println("Event Submitted: ${event.description}, ${event.type}, ${event.dateTime}")
        }
    }
}
