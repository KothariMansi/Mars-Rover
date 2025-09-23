package com.kotharimansi.marsrover.service.model

import kotlinx.serialization.SerialName

data class PhotoManifestRemoteModel(
    @SerialName("landing_date") val landingDate: String,
    @SerialName("launch_date") val launchDate: String,
    @SerialName("max_date") val maxDate: String,
    @SerialName("max_sol") val maxSol: String,
    val name: String,
    @SerialName("photo") val photo: List<ManifestPhotoRemoteModel>,
    @SerialName("total_photos") val totalPhoto: Int
)