package com.kotharimansi.marsrover.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kotharimansi.marsrover.R
import com.kotharimansi.marsrover.domain.model.RoverManifestUIModel
import com.kotharimansi.marsrover.ui.theme.MarsRoverTheme

@Composable
fun ManifestList(
    roverManifestUIModelList: List<RoverManifestUIModel>
) {
    Scaffold(
        contentColor = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(roverManifestUIModelList) {
                Manifest(it)
            }
        }
    }
}

@Composable
fun Manifest(
    roverManifestUIModel: RoverManifestUIModel
) {
    Card(modifier = Modifier.padding(16.dp).fillMaxWidth().clickable{}) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = stringResource(R.string.sol, roverManifestUIModel.sol))
            Text(text = stringResource(R.string.earth_date, roverManifestUIModel.earthDate))
            Text(text = stringResource(R.string.number_of_photo,roverManifestUIModel.photoNumber))
        }
    }
}

@Preview
@Composable
fun ManifestPreview() {
    MarsRoverTheme {
        Manifest(RoverManifestUIModel(
            sol = "1000",
            earthDate = "2021-03-04",
            photoNumber = "5"
        ))
    }
}