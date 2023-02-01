package com.example.tfl.presentation.state

import com.example.tfl.data.remote.TubeLineResponsesItem

data class TubeLineStatusState(
    val isLoading:Boolean = false,
    val tubeLineStatus: List<TubeLineResponsesItem> = emptyList(),
    val error: String = ""
)
