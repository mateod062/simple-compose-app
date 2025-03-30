package com.example.simplecomposeapp.ui.screen.superhero

import android.R
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simplecomposeapp.data.Superhero

@Composable
fun SuperheroListScreen(superheroes: List<Superhero>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(superheroes) { superhero ->
            SuperheroItem(superhero = superhero)
        }
    }
}

val sampleSuperheroes = listOf(
    Superhero("Iron Man", 48, R.drawable.placeholder),
    Superhero("Captain America", 102, R.drawable.placeholder),
    Superhero("Black Widow", 35, R.drawable.placeholder),
    Superhero("Thor", 1500, R.drawable.placeholder),
    Superhero("Hulk", 49, R.drawable.placeholder)
)

@Preview(showBackground = true)
@Composable
fun SuperheroListScreenPreview() {
    SuperheroListScreen(superheroes = sampleSuperheroes)
}