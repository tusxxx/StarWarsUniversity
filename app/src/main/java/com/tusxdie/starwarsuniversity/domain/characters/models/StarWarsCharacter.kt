package com.tusxdie.starwarsuniversity.domain.characters.models

data class StarWarsCharacter(
    val id: Int,
    val name: String,
    val birthYear: String,
    val gender: Gender
) {
    enum class Gender {
        MALE, FEMALE
    }
}
