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

fun toUIModel(marsRoverSavedLocalModelList: List<MarsRoverSavedLocalModel>) = marsRoverSavedLocalModelList.map { photo->
    RoverPhotoUIModel(
        id = photo.roverPhotoId,
        roverName = photo.roverName,
        imgSrc = photo.imgSrc,
        sol = photo.sol,
        earthDate = photo.earthDate,
        cameraFullName = photo.cameraFullName,
        isSaved = true
    )
}