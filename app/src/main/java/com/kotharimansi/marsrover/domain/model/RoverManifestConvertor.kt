package com.kotharimansi.marsrover.domain.model

import com.kotharimansi.marsrover.service.model.RoverManifestRemoteModel

fun toUiModel(roverManifestRemoteUIModel: RoverManifestRemoteModel): RoverManifestUIState =
    RoverManifestUIState.Success(roverManifestRemoteUIModel.photoManifest.photos.map { photo ->
        RoverManifestUIModel(
            sol = photo.sol.toString(),
            earthDate = photo.earthDate,
            photoNumber = photo.totalPhotos.toString()
        )
    }.sorted())