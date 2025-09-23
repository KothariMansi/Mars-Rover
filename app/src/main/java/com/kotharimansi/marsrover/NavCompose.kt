package com.kotharimansi.marsrover

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kotharimansi.marsrover.nav.Actions
import com.kotharimansi.marsrover.nav.Destinations
import com.kotharimansi.marsrover.ui.theme.MarsRoverTheme
import com.kotharimansi.marsrover.ui.view.ManifestScreen
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
                    roverName = backStackEntry.arguments?.getString("roverName")
                )
            }
        }
    }
}