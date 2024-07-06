package com.tusxdie.starwarsuniversity.ui.film

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.tusxdie.starwarsuniversity.ui.film.components.CharacterCard
import com.tusxdie.starwarsuniversity.ui.theme.medium
import com.tusxdie.starwarsuniversity.ui.theme.small
import com.tusxdie.starwarsuniversity.ui.utils.LCEView
import org.koin.androidx.compose.koinViewModel

@Composable
fun FilmScreen(
    filmId: Int,
    onNavigateToWorldScreen: (Int) -> Unit = {},
) {
    val viewModel = koinViewModel<FilmViewModel>()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(filmId) {
        viewModel.fetchFilm(filmId)
    }

    LCEView(lce = state.lce) {
        FilmScreenBody(
            state = state,
            onCharacterClick = onNavigateToWorldScreen
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilmScreenBody(
    state: FilmScreenState,
    onCharacterClick: (Int) -> Unit = {},
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = medium)) {
        TopAppBar(title = { Text(text = state.filmTitle) })
        Spacer(modifier = Modifier.height(medium))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(small)) {
            items(state.characters) { character ->
                CharacterCard(
                    character = character,
                    onClick = onCharacterClick,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}