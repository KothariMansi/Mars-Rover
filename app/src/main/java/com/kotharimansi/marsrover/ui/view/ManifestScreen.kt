package com.kotharimansi.marsrover.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.kotharimansi.marsrover.domain.model.RoverManifestUIState
import com.kotharimansi.marsrover.ui.manifestlist.MarsRoverManifestViewModel

@Composable
fun ManifestScreen(
    roverName: String?,
    marsRoverManifestViewModel: MarsRoverManifestViewModel,
    onCLick: (roverName: String, sol: String) -> Unit
) {
    val viewState by marsRoverManifestViewModel.roverManifestUIState.collectAsState()
    if (roverName != null) {
        LaunchedEffect(Unit) {
            marsRoverManifestViewModel.getMarsRoverManifest(roverName)
        }
        when (val roverManifestUIState = viewState) {
            RoverManifestUIState.Error -> Error()
            RoverManifestUIState.Loading -> Loading()
            is RoverManifestUIState.Success -> ManifestList(
                roverManifestUIModelList = roverManifestUIState.roverManifestUIModel, roverName = roverName,
                onCLick = onCLick
            )
        }
    }
}
