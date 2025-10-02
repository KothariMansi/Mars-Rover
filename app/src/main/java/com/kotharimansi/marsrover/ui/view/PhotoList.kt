package com.kotharimansi.marsrover.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.kotharimansi.marsrover.R
import com.kotharimansi.marsrover.domain.model.RoverPhotoUIModel

@Composable
fun PhotoList(
    modifier: Modifier,
    roverPhotoUIModels: List<RoverPhotoUIModel>,
    onClick: (roverPhotoUIModel: RoverPhotoUIModel) -> Unit
) {

    Scaffold(modifier = Modifier, containerColor = MaterialTheme.colorScheme.background) { paddingValues ->
        LazyColumn(modifier = modifier.padding(paddingValues = paddingValues)) {
            items(roverPhotoUIModels) { roverPhotoUIModel ->
                Photo(roverPhotoUIModel, onClick = { onClick(roverPhotoUIModel) })
            }
        }
    }
}

@Composable
fun Photo(
    roverPhotoUIModel: RoverPhotoUIModel,
    onClick: (roverPhotoUIModel: RoverPhotoUIModel) -> Unit
) {
    Card(modifier = Modifier.padding(16.dp).fillMaxWidth().clickable{
        onClick(roverPhotoUIModel)
    }) {
        Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                Image(
                    painter = painterResource(
                        if (roverPhotoUIModel.isSaved) R.drawable.ic_save_outline
                        else R.drawable.ic_save
                    ),
                    contentDescription = "save icon",
                    modifier = Modifier.padding(4.dp)
                )
                Text(text = roverPhotoUIModel.roverName,
                    modifier = Modifier,
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize)
            }

            AsyncImage(
                model = roverPhotoUIModel.imgSrc, contentDescription = "rover photo",
                modifier = Modifier.height(300.dp).fillMaxWidth().padding(vertical = 4.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = stringResource(R.string.sol, roverPhotoUIModel.sol))
            Text(text = stringResource(R.string.earth_date, roverPhotoUIModel.earthDate))
            Text(text = roverPhotoUIModel.cameraFullName)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PhotoPreview() {
    Photo(roverPhotoUIModel = RoverPhotoUIModel(
        id = 1,
        roverName = "Curiosity",
        imgSrc = "https://mars.nasa.gov/msl-raw-images/msss/04669/mrdi/4669MD0017280000303124E01_DXXX.jpg",
        sol = "34",
        earthDate = "2021-03-03",
        cameraFullName = "Mast Camera Zoom - Right",
        isSaved = false
    )) {}
}