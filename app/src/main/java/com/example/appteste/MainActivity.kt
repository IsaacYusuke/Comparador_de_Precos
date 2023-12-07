package com.example.appteste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    // A variable that holds the state of the counter
    var counter by remember { mutableStateOf(0) }

    // Material Design surface container
    Surface(color = MaterialTheme.colorScheme.inverseOnSurface) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text = "You have pressed the button this many times:")
            Text(text = "$counter", style = MaterialTheme.typography.titleLarge)
            Button(onClick = { counter++ }) {
                Text("Somar 1")
            }
            Button(onClick = { counter-- }) {
                Text("Diminuir 1")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}
