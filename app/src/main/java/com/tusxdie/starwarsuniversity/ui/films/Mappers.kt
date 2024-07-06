package com.tusxdie.starwarsuniversity.ui.films

import com.tusxdie.starwarsuniversity.domain.films.models.Film

fun Film.toUI() = FilmsScreenState.FilmUI(
    title = title,
    director = director,
    producer = producer,
    releaseDate = releaseDate.toString(),
    episodeId = urlId
)