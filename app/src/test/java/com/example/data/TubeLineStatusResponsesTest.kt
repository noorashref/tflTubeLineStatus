package com.example.data


import com.example.tfl.data.remote.*
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class TubeLineStatusResponsesTest {

    @Test
    fun `test add item to TubeLineResponses`() {
        val tubeLineResponses = TubeLineResponses()
        val tubeLineResponsesItem = TubeLineResponsesItem(
            created = "",
            crowding = Crowding(type = ""),
            disruptions = emptyList(),
            id = "",
            lineStatuses = emptyList(),
            modeName = "",
            modified = "",
            name = "",
            routeSections = emptyList(),
            serviceTypes = emptyList(),
            type = ""
        )

        tubeLineResponses.add(tubeLineResponsesItem)
        val result = tubeLineResponses[0]

        Assert.assertEquals(tubeLineResponsesItem, result)
    }

    @Test
    fun `test remove item from TubeLineResponses`() {
        val tubeLineResponses = TubeLineResponses()
        val tubeLineResponsesItem = TubeLineResponsesItem(
            created = "",
            crowding = Crowding(type = ""),
            disruptions = emptyList(),
            id = "",
            lineStatuses = emptyList(),
            modeName = "",
            modified = "",
            name = "",
            routeSections = emptyList(),
            serviceTypes = emptyList(),
            type = ""
        )

        tubeLineResponses.add(tubeLineResponsesItem)
        tubeLineResponses.remove(tubeLineResponsesItem)
        val result = tubeLineResponses.isEmpty()

        Assert.assertTrue(result)
    }
}
