package com.kotharimansi.marsrover.domain.model

sealed class RoverManifestUIState {
    data class Success(
        val roverManifestUIModel: List<RoverManifestUIModel>
    ): RoverManifestUIState()
    object Loading: RoverManifestUIState()
    object Error: RoverManifestUIState()
}

data class RoverManifestUIModel(
    val sol: String,
    val earthDate: String,
    val photoNumber: String,
): Comparable<RoverManifestUIModel> {
    override fun compareTo(other: RoverManifestUIModel): Int = other.earthDate.compareTo(this.earthDate)
}
