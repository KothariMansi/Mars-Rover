package com.kotharimansi.marsrover.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kotharimansi.marsrover.R
import com.kotharimansi.marsrover.domain.model.roverUIModelList
import com.kotharimansi.marsrover.ui.theme.MarsRoverTheme

@Composable
fun RoverList(
) {
    Scaffold(
        contentColor = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(roverUIModelList) {
                Rover(name = it.name, image = it.image, landingDate = it.landingDate, distance = it.distance)
            }
        }
    }
}

@Composable
fun Rover(
    name: String,
    image: Int,
    landingDate: String,
    distance: String
) {
    Card(
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(bottom = 4.dp),
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Image(
                painter = painterResource(id = image), contentDescription = null,
                modifier = Modifier.fillMaxWidth().height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = "Credit: NASA/JPL", fontSize = 8.sp)
            Text(text = "Landing Date: $landingDate", fontSize = 12.sp)
            Text(text = "Distance traveled: $distance", fontSize = 12.sp)
        }
    }

}

@Preview
@Composable
fun RoverPreview() {
    MarsRoverTheme {
        Rover(
            name = "Perseverance",
            image = R.drawable.rover,
            landingDate = "18 February 2021",
            distance =  "12.56 km"
        )
    }
}
