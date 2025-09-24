package com.kotharimansi.marsrover.data

import com.kotharimansi.marsrover.domain.model.RoverManifestUIState
import com.kotharimansi.marsrover.domain.model.toUiModel
import com.kotharimansi.marsrover.service.MarsRoverManifestService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarsRoverManifestRepo @Inject constructor(
    private val marsRoverManifestService: MarsRoverManifestService
) {
    fun getMarsRoverManifest(roverName: String): Flow<RoverManifestUIState> = flow {
        try {
            emit(
                toUiModel(marsRoverManifestService.getMarsRoverManifest(roverName.lowercase()))
            )
        } catch (throwable: Throwable) {
            emit(RoverManifestUIState.Error)
        }
    }
}