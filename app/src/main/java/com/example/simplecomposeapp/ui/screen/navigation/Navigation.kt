package com.example.simplecomposeapp.ui.screen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.simplecomposeapp.Screen
import com.example.simplecomposeapp.ui.screen.counter.CounterScreen
import com.example.simplecomposeapp.ui.screen.animation.AnimationScreen
import com.example.simplecomposeapp.ui.screen.superhero.SuperheroListScreen
import com.example.simplecomposeapp.ui.screen.superhero.sampleSuperheroes

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.COUNTER.name) {
        composable(Screen.COUNTER.name) {
            CounterScreen(navController = navController)
        }
        composable(Screen.SUPERHERO_LIST.name) {
            SuperheroListScreen(sampleSuperheroes)
        }
        composable(Screen.ANIMATION.name) {
            AnimationScreen()
        }
    }
}
