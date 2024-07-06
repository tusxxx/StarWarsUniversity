package com.tusxdie.starwarsuniversity.data.repositories.films

import androidx.core.net.toUri
import com.tusxdie.starwarsuniversity.data.database.films.FilmEntity
import com.tusxdie.starwarsuniversity.data.network.models.FilmResponse
import com.tusxdie.starwarsuniversity.data.network.models.FilmsResponse
import com.tusxdie.starwarsuniversity.domain.films.models.Film
import kotlinx.datetime.LocalDate

fun FilmsResponse.Result.toDomain(): Film = Film(
    title = title,
    director = director,
    producer = producer,
    releaseDate = LocalDate.parse(releaseDate),
    urlId = url.toUri().lastPathSegment?.toInt() ?: throw Exception("Parse error\n$url"),
    charactersIds = characters.map {
        it.toUri().lastPathSegment?.toInt() ?: throw Exception("Parse error\n$characters")
    }
)

fun FilmResponse.toDomain(): Film = Film(
    title = title,
    director = director,
    producer = producer,
    releaseDate = LocalDate.parse(releaseDate),
    urlId = url.toUri().lastPathSegment?.toInt() ?: throw Exception("Parse error\n$url"),
    charactersIds = characters.map {
        it.toUri().lastPathSegment?.toInt() ?: throw Exception("Parse error\n$characters")
    }
)

fun FilmEntity.toDomain(): Film = Film(
    title = title,
    director = director,
    producer = producer,
    releaseDate = releaseDate,
    urlId = urlId,
    charactersIds = charactersIds
)

fun Film.toEntity(): FilmEntity = FilmEntity(
    title = title,
    director = director,
    producer = producer,
    releaseDate = releaseDate,
    urlId = urlId,
    charactersIds = charactersIds
)