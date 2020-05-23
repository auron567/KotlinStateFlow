package com.example.kotlinstateflow.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.kotlinstateflow.databinding.ActivityMainBinding
import com.example.kotlinstateflow.viewmodel.MainViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setCountObserver()
        setButtons()
    }

    private fun setCountObserver() {
        lifecycleScope.launch {
            viewModel.countState.collect { value ->
                binding.countTextView.text = "$value"
                Timber.d("Collect StateFlow value: $value")
            }
        }
    }

    private fun setButtons() {
        binding.plusButton.setOnClickListener { viewModel.incrementCount() }
        binding.minusButton.setOnClickListener { viewModel.decrementCount() }
    }
}