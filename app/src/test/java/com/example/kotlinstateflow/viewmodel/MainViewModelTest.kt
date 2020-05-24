package com.example.kotlinstateflow.viewmodel

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import kotlin.random.Random

@ExperimentalCoroutinesApi
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        viewModel = MainViewModel()
    }

    @Test
    fun countState_initialValue() {
        assertEquals(0, viewModel.countState.value)
    }

    @Test
    fun incrementCount_checkValue() {
        val count = Random.nextInt(1, 100)
        repeat(count) {
            viewModel.incrementCount()
        }

        assertEquals(count, viewModel.countState.value)
    }

    @Test
    fun decrementCount_checkValue() {
        val count = Random.nextInt(1, 100)
        repeat(count) {
            viewModel.decrementCount()
        }

        assertEquals(-count, viewModel.countState.value)
    }
}