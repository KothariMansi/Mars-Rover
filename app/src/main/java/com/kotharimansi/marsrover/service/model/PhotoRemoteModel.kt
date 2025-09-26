package com.kotharimansi.marsrover.service.model

import com.google.gson.annotations.SerializedName

data class PhotoRemoteModel(
    val camera: CameraRemoteModel,
    @SerializedName("earth_date") val earthDate: String,
    val id: Int,
    @SerializedName("img_src") val imgSrc: String,
    val rover: RoverRemoteModel,
    val sol: String
)
