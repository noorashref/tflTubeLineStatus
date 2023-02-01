package com.example.tfl.data.dto


import com.example.tfl.data.remote.TubeLineResponsesItem
import com.example.tfl.domain.model.TubeLineStatusModel
import com.google.gson.annotations.SerializedName

data class TubeLineResponsesItemDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    )

fun TubeLineResponsesItem.toTubeLineStatusModel(): TubeLineStatusModel {
    return TubeLineStatusModel(
        name = name,
        id = id,
    )
}