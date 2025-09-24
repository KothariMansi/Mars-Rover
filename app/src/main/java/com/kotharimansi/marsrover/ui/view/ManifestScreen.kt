package com.kotharimansi.marsrover.ui.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import com.kotharimansi.marsrover.ui.manifestlist.MarsRoverManifestViewModel
import com.kotharimansi.marsrover.ui.theme.MarsRoverTheme

@Composable
fun ManifestScreen(
    roverName: String?,
    marsRoverManifestViewModel: MarsRoverManifestViewModel
) {
    if (roverName != null) {
        LaunchedEffect(Unit) {
            marsRoverManifestViewModel.getMarsRoverManifest(roverName)
        }
    }
    Text(text = "Manifest Screen $roverName")
}

@Preview
@Composable
fun ManifestScreenPreview() {
    MarsRoverTheme {
        //ManifestScreen("Perseverance")
    }
}