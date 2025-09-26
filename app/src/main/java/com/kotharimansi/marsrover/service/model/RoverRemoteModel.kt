package com.kotharimansi.marsrover.service.model

import com.google.gson.annotations.SerializedName

data class RoverRemoteModel(
    val id: Int,
    @SerializedName("landing_date") val landingDate: String,
    @SerializedName("launch_date") val launchDate: String,
    val name: String,
    val status: String
)