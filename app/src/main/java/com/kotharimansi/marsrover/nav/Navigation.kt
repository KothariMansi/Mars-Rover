package com.kotharimansi.marsrover.nav

import androidx.navigation.NavController

object Destinations {
    const val HOME = "home"
    const val MANIFEST = "manifest/{roverName}"
    const val PHOTO = "photo/{roverName}?sol={sol}"
}

class Actions(navController: NavController) {
    val home: () -> Unit = { navController.navigate(Destinations.HOME) }
    val manifest: (roverName: String) -> Unit = { roverName ->
        navController.navigate("manifest/$roverName")
    }
    val photo: (roverName: String, sol: String) -> Unit = { roverName, sol ->
        navController.navigate("photo/$roverName?sol=$sol")
    }
}