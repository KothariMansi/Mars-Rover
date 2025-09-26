package com.kotharimansi.marsrover

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kotharimansi.marsrover.nav.Actions
import com.kotharimansi.marsrover.nav.Destinations
import com.kotharimansi.marsrover.ui.theme.MarsRoverTheme
import com.kotharimansi.marsrover.ui.view.ManifestScreen
import com.kotharimansi.marsrover.ui.view.PhotoScreen
import com.kotharimansi.marsrover.ui.view.RoverList

@Composable
fun NavCompose() {
    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }
    MarsRoverTheme {
        NavHost(navController, Destinations.HOME) {
            composable(Destinations.HOME) {
                RoverList { roverName -> actions.manifest(roverName) }
            }

            composable(Destinations.MANIFEST) { backStackEntry ->
                ManifestScreen(
                    roverName = backStackEntry.arguments?.getString("roverName"),
                    marsRoverManifestViewModel = hiltViewModel(),
                    onCLick = { roverName, sol -> actions.photo(roverName, sol) }
                )
            }
            composable(Destinations.PHOTO) { backStackEntry ->
                PhotoScreen(
                    roverName = backStackEntry.arguments?.getString("roverName"),
                    sol = backStackEntry.arguments?.getString("sol"),
                    marsRoverPhotoViewModel = hiltViewModel()
                )
            }
        }
    }
}