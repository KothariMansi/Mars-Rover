package com.kotharimansi.marsrover

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.kotharimansi.marsrover.ui.theme.MarsRoverTheme
import com.kotharimansi.marsrover.ui.view.RoverList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MarsRoverTheme {
                RoverList()
            }
        }
    }
}

