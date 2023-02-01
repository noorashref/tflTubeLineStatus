package com.example.tfl.domain.repo

import com.example.tfl.data.remote.TubeLineResponses

interface TubeLineRepository {

    suspend fun getTubeLineStatus() : TubeLineResponses
}