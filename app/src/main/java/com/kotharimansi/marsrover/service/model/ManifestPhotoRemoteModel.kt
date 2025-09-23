package com.kotharimansi.marsrover.service.model

import kotlinx.serialization.SerialName

data class ManifestPhotoRemoteModel(
    val cameras: List<String>,
    @SerialName("earth_date") val earthDate: String,
    val sol: Int,
    @SerialName("total_photos") val totalPhots: Int
)
