package com.example.mapd721_a2_divyanshoosinha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    // State for inputs and history
    var heartRate by remember { mutableStateOf("") }
    var dateTime by remember { mutableStateOf("") }
    val history = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Input Fields
        Column {
            Text("Heart Rate (1-300 bpm)", fontSize = 16.sp)
            BasicTextField(
                value = heartRate,
                onValueChange = { heartRate = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Text("Date/Time", fontSize = 16.sp)
            BasicTextField(
                value = dateTime,
                onValueChange = { dateTime = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }

        // Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    // Logic for loading data will go here
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Load")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    if (heartRate.isNotEmpty() && dateTime.isNotEmpty()) {
                        history.add("$heartRate bpm, $dateTime")
                        heartRate = ""
                        dateTime = ""
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Save")
            }
        }

        // Heart Rate History
        Column {
            Text("Heart Rate History", fontSize = 16.sp, modifier = Modifier.padding(vertical = 8.dp))
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(history.size) { index ->
                    Text(history[index], fontSize = 14.sp, modifier = Modifier.padding(4.dp))
                }
            }
        }

        // About Section
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Divyanshoo Sinha", fontSize = 16.sp)
            Text("123456445", fontSize = 14.sp, color = MaterialTheme.colorScheme.primary)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
