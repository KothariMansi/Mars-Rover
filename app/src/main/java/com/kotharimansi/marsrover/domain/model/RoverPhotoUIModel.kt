package com.kotharimansi.marsrover.domain.model

sealed class RoverPhotoUiState {
    data class Success(
        val roverPhotoUiModelList: List<RoverPhotoUIModel>
    ): RoverPhotoUiState()
    object Loading: RoverPhotoUiState()
    object Error: RoverPhotoUiState()
}

data class RoverPhotoUIModel(
    val id: Int,
    val roverName: String,
    val imgSrc: String,
    val sol: String,
    val earthDate: String,
    val cameraFullName: String
)
