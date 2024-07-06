package com.tusxdie.starwarsuniversity.ui.films

import androidx.lifecycle.viewModelScope
import com.tusxdie.starwarsuniversity.domain.films.FilmsRepository
import com.tusxdie.starwarsuniversity.ui.utils.LCE
import com.tusxdie.starwarsuniversity.ui.utils.StateViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FilmsViewModel(
    private val filmsRepository: FilmsRepository
) : StateViewModel<FilmsScreenState>(FilmsScreenState()) {
    fun fetchFilms() {
        viewModelScope.launch {
            filmsRepository.getFilms().collectLatest { films ->
                _state.update {
                    val filmsUI = films.map { it.toUI() }
                    it.copy(
                        films = filmsUI,
                        queriedFilms = filmsUI,
                        lce = LCE.Dormant
                    )
                }
            }
        }
    }

    fun onQueryChange(query: String) {
        _state.update {
            it.copy(
                query = query,
                queriedFilms = it.films.filter { it.title.contains(query, ignoreCase = true) }
            )
        }
    }
}