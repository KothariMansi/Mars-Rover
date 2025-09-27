package com.kotharimansi.marsrover.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.kotharimansi.marsrover.domain.model.RoverPhotoUiState
import com.kotharimansi.marsrover.ui.photolist.MarsRoverPhotoViewModel

@Composable
fun PhotoScreen(
    roverName: String?,
    sol: String?,
    marsRoverPhotoViewModel: MarsRoverPhotoViewModel,
    modifier: Modifier
) {
    val photoState by marsRoverPhotoViewModel.roverPhotoUiState.collectAsState()
    if (roverName != null && sol != null) {
        LaunchedEffect(Unit) {
            marsRoverPhotoViewModel.getMarsRoverPhoto(roverName, sol)
        }
    }
    when(val roverPhotoUiState = photoState) {
        RoverPhotoUiState.Error -> Error()
        RoverPhotoUiState.Loading -> Loading()
        is RoverPhotoUiState.Success -> PhotoList(modifier = modifier,roverPhotoUIModels = roverPhotoUiState.roverPhotoUiModelList)
    }
}