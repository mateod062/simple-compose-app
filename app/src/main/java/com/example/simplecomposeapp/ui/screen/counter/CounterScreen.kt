package com.example.simplecomposeapp.ui.screen.counter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.simplecomposeapp.Screen


@Composable
fun CounterScreen(
    navController: NavController
) {
    //var count by rememberSaveable { mutableIntStateOf(0) }
    var count = 0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(16.dp)

    ) {
        Text(
            text = "Jetpack Compose Overview",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Counter: $count",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row {
            Button(
                onClick = { count++ },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Increment", color = Color.White)
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = { count = 0 },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Reset", color = Color.White)
            }
        }

        Button(onClick = { navController.navigate(Screen.ANIMATION.name) }) {
            Text("Go to Animations")
        }

        Button(onClick = { navController.navigate(Screen.SUPERHERO_LIST.name) }) {
            Text("Go to Superhero List")
        }
    }
}
