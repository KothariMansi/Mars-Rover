package com.kotharimansi.marsrover.service.model

import com.google.gson.annotations.SerializedName

data class RoverManifestRemoteModel(
    @SerializedName("photo_manifest") val photoManifest: PhotoManifestRemoteModel
)
