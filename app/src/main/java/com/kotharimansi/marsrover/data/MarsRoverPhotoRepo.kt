package com.kotharimansi.marsrover.data

import com.kotharimansi.marsrover.db.MarsRoverSavedPhotoDao
import com.kotharimansi.marsrover.domain.model.RoverPhotoUIModel
import com.kotharimansi.marsrover.domain.model.RoverPhotoUiState
import com.kotharimansi.marsrover.domain.model.toDBModel
import com.kotharimansi.marsrover.domain.model.toUIModel
import com.kotharimansi.marsrover.service.MarsRoverPhotoService
import com.kotharimansi.marsrover.service.model.RoverPhotoRemoteModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MarsRoverPhotoRepo @Inject constructor(
    private val marsRoverPhotoService: MarsRoverPhotoService,
    private val marsRoverSavedPhotoDao: MarsRoverSavedPhotoDao
) {

    fun getAllRemoteMarsRoverPhoto(roverName: String, sol: String): Flow<RoverPhotoRemoteModel?> =  flow {
        try {
            val networkResult = marsRoverPhotoService.getMarsRoverPhotos(roverName.lowercase(), sol)
            emit(networkResult)
        } catch (throwable: Throwable) {
            emit(null)
        }
    }

    fun getMarsRoverPhotos(roverName: String, sol: String): Flow<RoverPhotoUiState> =
        marsRoverSavedPhotoDao.allSavedId(sol, roverName).combine(getAllRemoteMarsRoverPhoto(roverName, sol)
        ) { local, remote ->
            remote?.let { roverPhotoRemoteModel ->
                RoverPhotoUiState.Success(roverPhotoRemoteModel.photos.map { photo ->
                    RoverPhotoUIModel(
                        id = photo.id,
                        roverName = photo.rover.name,
                        imgSrc = photo.imgSrc,
                        sol = photo.sol.toString(),
                        earthDate = photo.earthDate,
                        cameraFullName = photo.camera.fullName,
                        isSaved = local.contains(photo.id)
                    )
                })
            } ?: run {
                RoverPhotoUiState.Error
            }
        }
    suspend fun savePhoto(roverPhotoUIModel: RoverPhotoUIModel) {
        marsRoverSavedPhotoDao.insert((toDBModel(roverPhotoUIModel)))
    }

    suspend fun removePhoto(roverPhotoUIModel: RoverPhotoUIModel) {
        marsRoverSavedPhotoDao.delete((toDBModel(roverPhotoUIModel)))
    }

    fun getAllSaved(): Flow<RoverPhotoUiState> = marsRoverSavedPhotoDao.getAllSaved().map {
        RoverPhotoUiState.Success(toUIModel(it))
    }

}