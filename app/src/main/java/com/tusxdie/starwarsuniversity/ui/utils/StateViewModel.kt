package com.tusxdie.starwarsuniversity.ui.utils

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class StateViewModel<T>(initialState: T) : ViewModel() {
    protected val _state = MutableStateFlow(initialState)
    val state: StateFlow<T> = _state.asStateFlow()
}
