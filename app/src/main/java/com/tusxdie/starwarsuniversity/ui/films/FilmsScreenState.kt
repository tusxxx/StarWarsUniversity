package com.tusxdie.starwarsuniversity.ui.films

import com.tusxdie.starwarsuniversity.ui.utils.LCE

data class FilmsScreenState(
    val lce: LCE = LCE.Loading,
    val query: String = "",
    val films: List<FilmUI> = emptyList(),
    val queriedFilms: List<FilmUI> = emptyList()
) {
    data class FilmUI(
        val title: String,
        val director: String,
        val producer: String,
        val releaseDate: String,
        val episodeId: Int
    )
}
