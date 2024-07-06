package com.tusxdie.starwarsuniversity.ui.film

import androidx.lifecycle.viewModelScope
import com.tusxdie.starwarsuniversity.domain.characters.GetCharactersByFilmIdUseCase
import com.tusxdie.starwarsuniversity.domain.films.FilmsRepository
import com.tusxdie.starwarsuniversity.ui.utils.LCE
import com.tusxdie.starwarsuniversity.ui.utils.StateViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FilmViewModel(
    private val getCharactersByFilmIdUseCase: GetCharactersByFilmIdUseCase,
    private val filmsRepository: FilmsRepository
) : StateViewModel<FilmScreenState>(FilmScreenState()) {
    fun fetchFilm(filmId: Int) {
        viewModelScope.launch {
            launch {
                getCharactersByFilmIdUseCase(filmId).collectLatest { characters ->
                    _state.update {
                        it.copy(
                            characters = characters.map { it.toUI() },
                            lce = LCE.Dormant
                        )
                    }
                }
            }
            launch {
                filmsRepository.getFilm(filmId).collectLatest { film ->
                    _state.update {
                        it.copy(filmTitle = film.title)
                    }
                }
            }
        }
    }
}
