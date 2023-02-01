package com.example.tfl.data.repo

import com.example.tfl.data.TubeLinesApi
import com.example.tfl.data.remote.TubeLineResponses
import com.example.tfl.data.remote.TubeLineResponsesItem
import com.example.tfl.domain.repo.TubeLineRepository
import javax.inject.Inject

class TubeLineRepositoryImpl @Inject constructor(
    private val api : TubeLinesApi) : TubeLineRepository {

    override suspend fun getTubeLineStatus(): TubeLineResponses {
        return api.getTubeLineStatus()
    }
}