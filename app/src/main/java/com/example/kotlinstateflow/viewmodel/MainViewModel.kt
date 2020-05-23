package com.example.kotlinstateflow.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import timber.log.Timber

@ExperimentalCoroutinesApi
class MainViewModel : ViewModel() {

    private val _countState = MutableStateFlow(0)
    val countState: StateFlow<Int>
        get() = _countState

    fun incrementCount() {
        _countState.value++
        Timber.d("Set StateFlow value: ${_countState.value}")
    }

    fun decrementCount() {
        _countState.value--
        Timber.d("Set StateFlow value: ${_countState.value}")
    }
}