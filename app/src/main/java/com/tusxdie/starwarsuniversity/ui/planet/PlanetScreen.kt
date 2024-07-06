package com.tusxdie.starwarsuniversity.ui.planet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.tusxdie.starwarsuniversity.R
import com.tusxdie.starwarsuniversity.ui.theme.medium
import com.tusxdie.starwarsuniversity.ui.utils.LCEView
import org.koin.androidx.compose.koinViewModel

@Composable
fun PlanetScreen(planetId: Int, onBackClick: () -> Unit = {}) {
    val viewModel = koinViewModel<PlanetViewModel>()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(planetId) {
        viewModel.fetchPlanet(planetId)
    }

    LCEView(lce = state.lce) {
        PlanetScreenContent(
            state = state,
            onBackClick = onBackClick
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PlanetScreenContent(
    state: PlanetScreenState,
    onBackClick: () -> Unit = {}
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = medium)
    ) {
        TopAppBar(
            title = {
                Text(text = state.planetUI.name, style = MaterialTheme.typography.titleLarge)
            },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                }
            },
        )

        Card {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(medium)
            ) {
                Text(
                    text = stringResource(R.string.diameter, state.planetUI.diameter),
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = stringResource(R.string.climate, state.planetUI.climate),
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = stringResource(R.string.gravity, state.planetUI.gravity),
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = stringResource(R.string.terrain, state.planetUI.terrain),
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = stringResource(R.string.population, state.planetUI.population),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}