package com.tusxdie.starwarsuniversity.ui.film

import com.tusxdie.starwarsuniversity.domain.characters.models.StarWarsCharacter

fun StarWarsCharacter.toUI() = FilmScreenState.FilmCharacter(
    id = id,
    name = name,
    birthYear = birthYear,
    gender = when (gender) {
        StarWarsCharacter.Gender.MALE -> FilmScreenState.FilmCharacter.Gender.MALE
        StarWarsCharacter.Gender.FEMALE -> FilmScreenState.FilmCharacter.Gender.FEMALE
    }
)