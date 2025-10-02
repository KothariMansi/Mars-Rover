package com.kotharimansi.marsrover.ui.photolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotharimansi.marsrover.data.MarsRoverPhotoRepo
import com.kotharimansi.marsrover.domain.model.RoverPhotoUIModel
import com.kotharimansi.marsrover.domain.model.RoverPhotoUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarsRoverPhotoViewModel @Inject constructor(
    private val marsRoverPhotoRepo: MarsRoverPhotoRepo
): ViewModel() {

    private val _roverPhotoUiState: MutableStateFlow<RoverPhotoUiState> = MutableStateFlow(RoverPhotoUiState.Loading)
    val roverPhotoUiState = _roverPhotoUiState.asStateFlow()

    fun getMarsRoverPhoto(roverName: String, sol: String) {
        viewModelScope.launch {
            _roverPhotoUiState.value = RoverPhotoUiState.Loading
            marsRoverPhotoRepo.getMarsRoverPhotos(roverName, sol).collect {
                _roverPhotoUiState.value = it
            }
        }
    }

    fun changeSaveStatus(roverPhotoUIModel: RoverPhotoUIModel) {
        viewModelScope.launch(Dispatchers.IO) {
            if (roverPhotoUIModel.isSaved) {
                marsRoverPhotoRepo.removePhoto(roverPhotoUIModel)
            } else {
                marsRoverPhotoRepo.savePhoto(roverPhotoUIModel)
            }
        }
    }

}