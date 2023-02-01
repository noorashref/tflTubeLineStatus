package com.example.tfl.domain.use_case

import com.example.tfl.data.remote.TubeLineResponses
import com.example.tfl.data.remote.TubeLineResponsesItem
import com.example.tfl.domain.repo.TubeLineRepository
import com.example.tfl.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class TubeStatusUseCase @Inject constructor(
    private  val repo : TubeLineRepository
) {

    operator fun invoke() : Flow<Resource<List<TubeLineResponsesItem>>> = flow {
        try {
            emit(Resource.Loading())
            val tubeStatus = repo.getTubeLineStatus().map { it }
        emit(Resource.Success(tubeStatus))
    } catch (e: HttpException) {
        emit(
            Resource.Error<List<TubeLineResponsesItem>>(
                e.localizedMessage ?: "An unexpected error occured"
            )
        )
    } catch (e: IOException) {
        emit(Resource.Error<List<TubeLineResponsesItem>>("Couldn't reach server. Check your internet connection."))
    }
    }
}