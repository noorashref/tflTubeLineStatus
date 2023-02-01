package com.example.data

import com.example.tfl.data.remote.Crowding
import com.example.tfl.data.remote.TubeLineResponses
import com.example.tfl.data.remote.TubeLineResponsesItem
import com.example.tfl.domain.repo.TubeLineRepository
import com.example.tfl.domain.use_case.TubeStatusUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test

@ExperimentalCoroutinesApi
class TubeStatusUseCaseTest {

    private val mockRepo = mockk<TubeLineRepository>()

    private val tubeStatusUseCase = TubeStatusUseCase(mockRepo)

    @Test
    fun `test successful flow`() = runBlockingTest {
        val tubeLineResponses : TubeLineResponses = TubeLineResponses();

        val tubeStatusList = listOf<TubeLineResponsesItem>(
            TubeLineResponsesItem( created = "",
                crowding = Crowding(type = ""),
                disruptions = emptyList(),
                id = "",
                lineStatuses = emptyList(),
                modeName = "",
                modified = "",
                name = "",
                routeSections = emptyList(),
                serviceTypes = emptyList(),
                type = ""),
        );
        tubeLineResponses.addAll(tubeStatusList)

        coEvery{ mockRepo.getTubeLineStatus() } returns (tubeLineResponses)

        val result = runBlocking {
            tubeStatusUseCase().onEach { result ->
                val finalSuccessResponse = result.data
                assertEquals(tubeLineResponses, finalSuccessResponse)
            }
        }

    }
}
