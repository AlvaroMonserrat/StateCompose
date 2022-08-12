package com.rrat.statecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rrat.statecompose.ui.screens.WellnessScreen
import com.rrat.statecompose.ui.theme.StateComposeTheme
import com.rrat.statecompose.viewmodel.WellnessViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: WellnessViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateComposeTheme {
                WellnessScreen(viewModel=viewModel)
            }
        }
    }
}
