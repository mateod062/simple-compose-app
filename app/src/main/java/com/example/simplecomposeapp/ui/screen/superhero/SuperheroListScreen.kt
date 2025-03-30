package com.example.simplecomposeapp.ui.screen.superhero

import com.example.simplecomposeapp.R
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

val sampleSuperheroes= listOf(
    Superhero("Iron Man", 48, R.drawable.iron_man),
    Superhero("Captain America", 102, R.drawable.capetan_america),
    Superhero("Black Widow", 35, R.drawable.black_widow),
    Superhero("Thor", 1500, R.drawable.thor),
    Superhero("Hulk", 49, R.drawable.hulk),
    Superhero("Spider-Man", 17, R.drawable.spider_man),
    Superhero("Doctor Strange", 42, R.drawable.doctor_strange),
    Superhero("Black Panther", 40, R.drawable.black_panther),
    Superhero("Scarlet Witch", 32, R.drawable.scarlet_witch),
    Superhero("Ant-Man", 45, R.drawable.ant_man)
)

@Preview(showBackground = true)
@Composable
fun SuperheroListScreenPreview() {
    SuperheroListScreen(superheroes = sampleSuperheroes)
}