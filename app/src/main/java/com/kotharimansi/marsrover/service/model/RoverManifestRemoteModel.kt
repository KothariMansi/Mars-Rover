package com.kotharimansi.marsrover.service.model

import kotlinx.serialization.SerialName

data class RoverManifestRemoteModel(
    @SerialName("photo_manifest") val photoManifest: PhotoManifestRemoteModel
)
