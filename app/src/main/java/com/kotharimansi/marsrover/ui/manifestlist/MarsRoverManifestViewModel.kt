package com.kotharimansi.marsrover.ui.manifestlist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotharimansi.marsrover.data.MarsRoverManifestRepo
import com.kotharimansi.marsrover.domain.model.RoverManifestUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarsRoverManifestViewModel @Inject constructor(
    private val marsRoverManifestRepo: MarsRoverManifestRepo
): ViewModel() {

    private val _roverManifestUIState: MutableStateFlow<RoverManifestUIState> = MutableStateFlow(RoverManifestUIState.Loading)
    val roverManifestUIState = _roverManifestUIState.asStateFlow()


    fun getMarsRoverManifest(roverName: String) {
        viewModelScope.launch {
            _roverManifestUIState.value = RoverManifestUIState.Loading
            marsRoverManifestRepo.getMarsRoverManifest(roverName).collect {
                Log.d("Repository", "Response body: $it")
                _roverManifestUIState.value = it
            }
        }
    }
}