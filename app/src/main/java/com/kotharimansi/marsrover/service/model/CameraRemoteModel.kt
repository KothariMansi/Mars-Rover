package com.kotharimansi.marsrover.service.model

import com.google.gson.annotations.SerializedName

data class CameraRemoteModel(
    @SerializedName("full_name") val fullName: String,
    val id: Int,
    val name: String,
    @SerializedName("rover_id") val roverId: String
)