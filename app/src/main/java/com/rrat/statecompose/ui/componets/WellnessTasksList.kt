package com.rrat.statecompose.ui.componets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rrat.statecompose.data.WellnessTask


@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    taskList: List<WellnessTask> = emptyList(),
    onRemove: (WellnessTask)->Unit,
    onChangeChecked: (WellnessTask, Boolean)->Unit
){
    LazyColumn(
        modifier = modifier,
        state = rememberLazyListState()
    ){
        items(
            items = taskList,
            key = {task -> task.id}
            ){
                task->
            Card(
                modifier = Modifier.padding(2.dp),
                elevation = 4.dp
            ) {
                WellnessTaskItem(
                    modifier=Modifier.padding(8.dp),
                    taskName = task.label,
                    isChecked = task.checked,
                    onChecked = { onChangeChecked(task, it) },
                    onClose = {onRemove(task)}
                )
            }
        }
    }
}

@Composable
fun StatefulWellnessTaskItem(
    modifier: Modifier = Modifier,
    task: WellnessTask,
    onRemove: () -> Unit,
    onChangeChecked: (Boolean) -> Unit
){
    //var checkedState by rememberSaveable { mutableStateOf(false) }
    //var close by rememberSaveable { mutableStateOf(true) }

    WellnessTaskItem(
        modifier= modifier,
        taskName = task.label,
        isChecked = task.checked,
        onChecked = { onChangeChecked(it) },
        onClose = onRemove
    )
}