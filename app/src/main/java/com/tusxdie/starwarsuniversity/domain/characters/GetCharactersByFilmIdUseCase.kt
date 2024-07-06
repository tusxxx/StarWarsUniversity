package com.tusxdie.starwarsuniversity.domain.characters

import com.tusxdie.starwarsuniversity.domain.characters.models.StarWarsCharacter
import com.tusxdie.starwarsuniversity.domain.exceptions.FilmNotFoundException
import com.tusxdie.starwarsuniversity.domain.films.FilmsRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow

class GetCharactersByFilmIdUseCase(
    private val charactersRepository: CharactersRepository,
    private val filmsRepository: FilmsRepository
) {
    operator fun invoke(filmId: Int): Flow<List<StarWarsCharacter>> = flow {
        val film = filmsRepository.getFilm(filmId).firstOrNull() ?: throw FilmNotFoundException()
        val characterIds = film.charactersIds
        // Ускоряем загрузку персонажа по одному
        val characters = coroutineScope {
            characterIds
                .map {
                    async {
                        charactersRepository.getCharacter(it).firstOrNull()
                    }
                }
                .awaitAll()
                .filterNotNull()
        }
        emit(characters)
    }
}