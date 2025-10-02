package com.kotharimansi.marsrover.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.kotharimansi.marsrover.domain.model.RoverPhotoUiState
import com.kotharimansi.marsrover.ui.savelist.MarsRoverSavedViewModel

@Composable
fun PhotoListSaveScreen(
    modifier: Modifier = Modifier,
    marsRoverSavedViewModel: MarsRoverSavedViewModel
) {
    val photoState by marsRoverSavedViewModel.marsRoverPhotoUiState.collectAsState()
    LaunchedEffect(Unit) {
        marsRoverSavedViewModel.getAllSaved()
    }

    when(val roverPhotoUiState = photoState) {
        RoverPhotoUiState.Error -> Error()
        RoverPhotoUiState.Loading -> Loading()
        is RoverPhotoUiState.Success -> PhotoList(modifier, roverPhotoUiState.roverPhotoUiModelList) { roverPhotoUIModel ->
            marsRoverSavedViewModel.changeSaveStatus(roverPhotoUIModel)
        }
    }
}