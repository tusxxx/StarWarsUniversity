package com.tusxdie.starwarsuniversity.data.repositories.films

import com.tusxdie.starwarsuniversity.data.database.films.FilmDao
import com.tusxdie.starwarsuniversity.data.network.StarWarsAPI
import com.tusxdie.starwarsuniversity.domain.films.models.Film
import com.tusxdie.starwarsuniversity.domain.films.FilmsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

class FilmsRepositoryImpl(
    private val api: StarWarsAPI,
    private val filmsDao: FilmDao,
    private val coroutineContext: CoroutineContext = Dispatchers.IO
) : FilmsRepository {
    override fun getFilms(): Flow<List<Film>> = flow {
        val filmEntities = filmsDao.getFilms().firstOrNull()
        if (filmEntities?.isNotEmpty() == true) {
            emit(filmEntities.map { it.toDomain() })
            return@flow
        }

        val films = api.getFilms().results.map { film ->
            film.toDomain()
        }.onEach {
            filmsDao.insertFilm(it.toEntity())
        }
        emit(films)
    }.flowOn(coroutineContext)

    override fun getFilm(id: Int): Flow<Film> = flow {
        val film = api.getFilm(id).toDomain()
        emit(film)
    }
}