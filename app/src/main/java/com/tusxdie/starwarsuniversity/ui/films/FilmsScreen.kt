package com.tusxdie.starwarsuniversity.ui.films

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.tusxdie.starwarsuniversity.ui.theme.extraSmall
import com.tusxdie.starwarsuniversity.ui.theme.medium
import com.tusxdie.starwarsuniversity.ui.theme.small
import com.tusxdie.starwarsuniversity.ui.utils.LCEView
import org.koin.androidx.compose.koinViewModel

@Composable
fun FilmsScreen(
    onNavigateToFilmScreen: (Int) -> Unit = {},
) {
    val viewModel = koinViewModel<FilmsViewModel>()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchFilms()
    }

    LCEView(lce = state.lce) {
        FilmsScreenBody(
            state = state,
            onFilmClick = onNavigateToFilmScreen,
            onQueryChange = { viewModel.onQueryChange(it) },
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
private fun FilmsScreenBody(
    state: FilmsScreenState,
    onFilmClick: (Int) -> Unit = { },
    onQueryChange: (String) -> Unit = {},
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = medium)
    ) {
        SearchBar(
            query = state.query,
            onQueryChange = onQueryChange,
            onSearch = {},
            active = false,
            onActiveChange = {},
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Search films") }
        ) {

        }
        Spacer(modifier = Modifier.height(medium))
        LazyColumn(
            Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(extraSmall)
        ) {
            items(state.queriedFilms) {
                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .animateItemPlacement(),
                    onClick = { onFilmClick(it.episodeId) },
                ) {
                    Column(
                        Modifier.padding(small),
                        verticalArrangement = Arrangement.spacedBy(small)
                    ) {
                        Text(text = it.title, style = MaterialTheme.typography.titleLarge)
                        Text(text = it.director, style = MaterialTheme.typography.bodyLarge)
                        Text(text = it.producer, style = MaterialTheme.typography.bodyLarge)
                        Text(text = it.releaseDate, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}