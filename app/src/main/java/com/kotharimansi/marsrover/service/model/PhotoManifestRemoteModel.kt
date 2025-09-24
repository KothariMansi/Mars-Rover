package com.kotharimansi.marsrover.service.model

import com.google.gson.annotations.SerializedName

data class PhotoManifestRemoteModel(
    @SerializedName("landing_date") val landingDate: String,
    @SerializedName("launch_date") val launchDate: String,
    @SerializedName("max_date") val maxDate: String,
    @SerializedName("max_sol") val maxSol: Int,
    val name: String,
    @SerializedName("photos") val photos: List<ManifestPhotoRemoteModel>,
    @SerializedName("total_photos") val totalPhotos: Int
)