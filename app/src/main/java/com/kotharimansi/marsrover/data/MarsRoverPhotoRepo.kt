package com.kotharimansi.marsrover.data

import android.util.Log
import com.kotharimansi.marsrover.domain.model.RoverPhotoUIModel
import com.kotharimansi.marsrover.domain.model.RoverPhotoUiState
import com.kotharimansi.marsrover.service.MarsRoverPhotoService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarsRoverPhotoRepo @Inject constructor(
    val marsRoverPhotoService: MarsRoverPhotoService
) {

    fun getMarsRoverPhotos(roverName: String, sol: String): Flow<RoverPhotoUiState> = flow {
        try {
            val networkResult = marsRoverPhotoService.getMarsRoverPhotos(roverName, sol)
            Log.d("Repository", "Response body: $networkResult")
            emit(RoverPhotoUiState.Success(networkResult.photos.map { photo ->
                RoverPhotoUIModel(
                    id = photo.id,
                    roverName = photo.rover.name,
                    imgSrc = photo.imgSrc,
                    sol = photo.sol,
                    earthDate = photo.earthDate,
                    cameraFullName = photo.camera.fullName
                )
            }))
        } catch (throwable: Throwable) {
            emit(RoverPhotoUiState.Error)
        }
    }
}