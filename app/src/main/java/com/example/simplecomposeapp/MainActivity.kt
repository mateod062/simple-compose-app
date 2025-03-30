package com.example.simplecomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simplecomposeapp.data.Superhero
import com.example.simplecomposeapp.ui.screen.counter.CounterScreen
import com.example.simplecomposeapp.ui.screen.superhero.SuperheroListScreen
import com.example.simplecomposeapp.ui.screen.superhero.sampleSuperheroes
import com.example.simplecomposeapp.ui.theme.DemoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DemoApp()
                }
            }
        }
    }
}

enum class Screen {
    COUNTER, SUPERHERO_LIST
}

@Composable
fun DemoApp() {
    var currentScreen by remember { mutableStateOf(Screen.COUNTER) }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            when (currentScreen) {
                Screen.COUNTER -> CounterScreen()
                Screen.SUPERHERO_LIST -> SuperheroListScreen(superheroes = sampleSuperheroes)
            }
        }
        NavigationBar {
            NavigationBarItem(
                selected = currentScreen == Screen.COUNTER,
                onClick = { currentScreen = Screen.COUNTER },
                icon = { Icon(Icons.Filled.Home, contentDescription = "Counter") },
                label = { Text("Counter") }
            )
            NavigationBarItem(
                selected = currentScreen == Screen.SUPERHERO_LIST,
                onClick = { currentScreen = Screen.SUPERHERO_LIST },
                icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = "Superheroes") },
                label = { Text("Superheroes") }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DemoAppPreview() {
    DemoAppTheme {
        DemoApp()
    }
}