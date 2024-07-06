package com.tusxdie.starwarsuniversity.ui.film

import com.tusxdie.starwarsuniversity.ui.utils.LCE


data class FilmScreenState(
    val characters: List<FilmCharacter> = emptyList(),
    val filmTitle: String = "",
    val lce: LCE = LCE.Loading
) {
    data class FilmCharacter(
        val name: String,
        val id: Int,
        val birthYear: String,
        val gender: Gender
    ) {
        enum class Gender {
            MALE, FEMALE
        }
    }
}
