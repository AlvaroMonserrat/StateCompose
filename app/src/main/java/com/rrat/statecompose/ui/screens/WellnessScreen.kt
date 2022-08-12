package com.rrat.statecompose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rrat.statecompose.ui.componets.StatefulWaterCounter
import com.rrat.statecompose.ui.componets.WellnessTasksList
import com.rrat.statecompose.viewmodel.WellnessViewModel


@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    viewModel: WellnessViewModel
){

    Column() {
        StatefulWaterCounter()
        WellnessTasksList(
            modifier = modifier.padding(8.dp),
            viewModel.tasks,
            onRemove = { task ->
                viewModel.remove(task)
            },
            onChangeChecked = { task, check ->
                viewModel.changeTaskChecked(task, check)
            }
        )
    }
}




