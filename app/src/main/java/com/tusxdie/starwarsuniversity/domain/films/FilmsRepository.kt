package com.tusxdie.starwarsuniversity.domain.films

import com.tusxdie.starwarsuniversity.domain.films.models.Film
import kotlinx.coroutines.flow.Flow

interface FilmsRepository {
    fun getFilms(): Flow<List<Film>>
    fun getFilm(id: Int): Flow<Film>
}
