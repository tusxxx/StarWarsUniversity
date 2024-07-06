package com.tusxdie.starwarsuniversity.domain.films.models

import kotlinx.datetime.LocalDate

data class Film(
    val urlId: Int,
    val title: String,
    val director: String,
    val producer: String,
    val releaseDate: LocalDate,
    val charactersIds: List<Int>
)
