package com.rrat.statecompose.ui.componets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(
    modifier: Modifier = Modifier,
    count: Int,
    onIncrement: ()->Unit
)
{
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}

@Composable
fun StatefulWaterCounter(modifier: Modifier=Modifier)
{
    var count by rememberSaveable { mutableStateOf(0) }
    WaterCounter(modifier, count){
        count ++
    }
}

@Preview(widthDp = 480)
@Composable
fun WaterCounterPreview()
{
    WaterCounter(modifier=Modifier, 0) {}
}