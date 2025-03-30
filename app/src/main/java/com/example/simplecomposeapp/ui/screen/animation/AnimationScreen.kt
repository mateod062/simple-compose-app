package com.example.simplecomposeapp.ui.screen.animation

import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun AnimationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Fade In/Out Animation
        var visible by remember { mutableStateOf(true) }
        Button(onClick = { visible = !visible }) {
            Text("Toggle Fade")
        }

        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Text("Fading Text", modifier = Modifier.padding(16.dp))
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Color Change Animation
        var isRed by remember { mutableStateOf(true) }
        val color by animateColorAsState(
            targetValue = if (isRed) Color.Red else Color.Blue,
            animationSpec = tween(durationMillis = 3000),
            label = ""
        )
        Button(onClick = { isRed = !isRed }) {
            Text("Toggle Color")
        }
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Translation Animation with infinite repeat
        val infiniteTransition = rememberInfiniteTransition(label = "")
        val offset by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 200f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 3000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            ), label = ""
        )

        Text(
            "Moving Text",
            modifier = Modifier.offset(x = offset.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        var opacity by remember { mutableFloatStateOf(1f) }
        LaunchedEffect(Unit) {
            delay(2000)
            opacity = 0.2f
        }

        Text(
            "Delayed Fade",
            modifier = Modifier.alpha(opacity)
        )
    }
}
