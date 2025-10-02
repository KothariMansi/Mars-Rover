package com.kotharimansi.marsrover.ui.savelist

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
class MarsRoverSavedViewModel @Inject constructor(
    private val marsRoverPhotoRepo: MarsRoverPhotoRepo
): ViewModel() {
    private var _marsRoverPhotoUiState: MutableStateFlow<RoverPhotoUiState> = MutableStateFlow(RoverPhotoUiState.Loading)
    val marsRoverPhotoUiState = _marsRoverPhotoUiState.asStateFlow()

    fun getAllSaved() {
        viewModelScope.launch(Dispatchers.IO) {
            marsRoverPhotoRepo.getAllSaved().collect {
                _marsRoverPhotoUiState.value = it
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