package com.example.tfl.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tfl.data.remote.TubeLineResponsesItem
import com.example.tfl.domain.use_case.TubeStatusUseCase
import com.example.tfl.presentation.state.TubeLineStatusState
import com.example.tfl.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TubeLineStatusViewModel @Inject constructor(
    private val tubeLineUseCase: TubeStatusUseCase
): ViewModel(){

    private val _state = mutableStateOf(TubeLineStatusState())
    val state: State<TubeLineStatusState> = _state

    init {
        getTubeLineStatus()
    }

    fun  getTubeLineStatus() {
        tubeLineUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = TubeLineStatusState(tubeLineStatus = (result.data ?: emptyList()))
                }
                is Resource.Error -> {
                    _state.value = TubeLineStatusState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = TubeLineStatusState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}