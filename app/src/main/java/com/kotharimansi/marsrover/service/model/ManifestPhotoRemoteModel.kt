package com.kotharimansi.marsrover.service.model

import com.google.gson.annotations.SerializedName

data class ManifestPhotoRemoteModel(
    val cameras: List<String>,
    @SerializedName("earth_date") val earthDate: String,
    val sol: Int,
    @SerializedName("total_photos") val totalPhotos: Int
)
