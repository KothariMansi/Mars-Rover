package com.kotharimansi.marsrover

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kotharimansi.marsrover.nav.Actions
import com.kotharimansi.marsrover.nav.Destinations
import com.kotharimansi.marsrover.nav.Screen
import com.kotharimansi.marsrover.ui.theme.MarsRoverTheme
import com.kotharimansi.marsrover.ui.view.ManifestScreen
import com.kotharimansi.marsrover.ui.view.PhotoListSaveScreen
import com.kotharimansi.marsrover.ui.view.PhotoScreen
import com.kotharimansi.marsrover.ui.view.RoverList

@Composable
fun NavCompose() {
    val items = listOf(Screen.Home, Screen.Saved)
    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }
    MarsRoverTheme {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

                    items.forEach { screen ->

                        NavigationBarItem(
                            icon = {
                                Icon(painter = painterResource(screen.drawableId), contentDescription = stringResource(screen.resourceId))
                            },
                            label = {
                                Text(text = stringResource(screen.resourceId))
                            },
                            selected = currentDestination?.hierarchy?.any{
                                if (it.route?.contains("manifest") == true || it.route?.contains("photo") == true ) {
                                    screen.route == "home"
                                } else {
                                    it.route == screen.route
                                }
                            } == true,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {saveState = true}
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }

                        )
                    }
                }
            }
        ) { innerPadding ->

            val modifier = Modifier.padding(innerPadding)
            NavHost(navController, Destinations.HOME) {
                composable(Destinations.HOME) {
                    RoverList(modifier = modifier) { roverName -> actions.manifest(roverName) }
                }
                composable(Destinations.MANIFEST) { backStackEntry ->
                    ManifestScreen(
                        modifier = modifier,
                        roverName = backStackEntry.arguments?.getString("roverName"),
                        marsRoverManifestViewModel = hiltViewModel(),
                        onCLick = { roverName, sol -> actions.photo(roverName, sol) }
                    )
                }
                composable(Destinations.PHOTO) { backStackEntry ->
                    PhotoScreen(
                        modifier = modifier,
                        roverName = backStackEntry.arguments?.getString("roverName"),
                        sol = backStackEntry.arguments?.getString("sol"),
                        marsRoverPhotoViewModel = hiltViewModel()
                    )
                }
                composable(Destinations.SAVED) {
                    PhotoListSaveScreen(
                        modifier = modifier
                    )
                }
            }
        }

    }
}