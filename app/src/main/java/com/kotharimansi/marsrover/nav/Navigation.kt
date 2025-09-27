package com.kotharimansi.marsrover.nav

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.navigation.NavController
import com.kotharimansi.marsrover.R

object Destinations {
    const val HOME = "home"
    const val MANIFEST = "manifest/{roverName}"
    const val PHOTO = "photo/{roverName}?sol={sol}"
    const val SAVED = "saved"
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

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    @DrawableRes val drawableId: Int
) {
    object Home: Screen("home", R.string.rover, R.drawable.ic_mars_rover)
    object Saved: Screen("saved", R.string.saved, R.drawable.ic_save)
}