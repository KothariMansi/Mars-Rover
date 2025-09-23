package com.kotharimansi.marsrover.domain.model

import com.kotharimansi.marsrover.R

val roverUIModelList = listOf<RoverUIModel>(
    RoverUIModel(name = "Perseverance", image = R.drawable.rover, landingDate = "18 February 2021", distance = "12.56 km"),
    RoverUIModel(name = "Curiosity", image = R.drawable.rover2, landingDate = "6 August 2012", distance = "29.27 km"),
    RoverUIModel(name = "Opportunity", image = R.drawable.rover3, landingDate = "25 January 2004", distance = "45.16 km"),
    RoverUIModel(name = "Spirit", image = R.drawable.rover4, landingDate = "4 January 2004", distance = "7.73 km"),
)