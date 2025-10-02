package com.kotharimansi.marsrover.domain.model

import com.kotharimansi.marsrover.db.MarsRoverSavedLocalModel

fun toDBModel(roverPhotoUIModel: RoverPhotoUIModel): MarsRoverSavedLocalModel {
    return MarsRoverSavedLocalModel(
        roverPhotoId = roverPhotoUIModel.id,
        roverName = roverPhotoUIModel.roverName,
        imgSrc = roverPhotoUIModel.imgSrc,
        sol = roverPhotoUIModel.sol,
        earthDate = roverPhotoUIModel.earthDate,
        cameraFullName = roverPhotoUIModel.cameraFullName
    )
}