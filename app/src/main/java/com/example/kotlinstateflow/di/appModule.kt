package com.example.kotlinstateflow.di

import com.example.kotlinstateflow.viewmodel.MainViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

@ExperimentalCoroutinesApi
val appModule = module {

    // MainViewModel instance
    viewModel { MainViewModel() }
}