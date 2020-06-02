# Kotlin StateFlow
Sample Android application that show how can we use Kotlin Coroutines `StateFlow`.
## Implementation
`StateFlow` is a new class introduced in version 1.3.6 of the Kotlin Coroutines library which works in the following way:

- It's a `Flow` with a single updatable data value that emits updates to the value to its collectors.
- Updates to the value can be observed by collecting values from this flow.
- It's useful as a data-model class to represent any kind of state.
- It's designed to completely replace `ConflatedBroadcastChannel` in the future.

<br><br>
For example, the following class represents an integer state that increments its value by calling the method `incrementCount`:
```kt
class CountModel {
    private val _countState = MutableStateFlow(0) // Private mutable state flow
    val countState: StateFlow<Int> get() = _countState // Public read-only state flow

    fun incrementCount() {
        _countState.value++
    }
}
```
Now in a possible activity we can observe `countState` to keep track of its updates:
```kt
lifecycleScope.launch {
    countModel.countState.collect { value ->
        countTextView.text = "$value"
    }
}
```
This collector will be executed whenever the value of `countState` is updated. Also it's **lifecycle-aware** as we’ve used it under `lifecycleScope`.
## Libraries
- [Kotlin](https://kotlinlang.org/) + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
- Jetpack
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
  - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle)
- [Koin](https://github.com/InsertKoinIO/koin)
- [Timber](https://github.com/JakeWharton/timber)
## References
- [StateFlow, End of LiveData?](https://medium.com/scalereal/stateflow-end-of-livedata-a473094229b3)
- [StateFlow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-state-flow/index.html)
