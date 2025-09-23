package com.kotharimansi.marsrover.nav

import androidx.navigation.NavController

object Destinations {
    const val HOME = "home"
    const val MANIFEST = "manifest/{roverName}"
}

class Actions(navController: NavController) {
    val home: () -> Unit = { navController.navigate(Destinations.HOME) }
    val manifest: (roverName: String) -> Unit = { roverName ->
        navController.navigate("manifest/$roverName")
    }
}