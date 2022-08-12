package com.rrat.statecompose.viewmodel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.rrat.statecompose.data.WellnessTask


class WellnessViewModel(): ViewModel(){

    //This should be in a repository
    private fun getWellnessTask() = List(30) { i -> WellnessTask(i, "Task # $i") }

    private val _tasks = getWellnessTask().toMutableStateList()

    //_tasks only can be changed by ViewModel
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask){
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean){
        tasks.find { it.id == item.id }?.let {
            task ->
            task.checked = checked
        }
    }
}