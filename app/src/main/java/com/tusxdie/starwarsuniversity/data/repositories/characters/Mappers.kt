package com.tusxdie.starwarsuniversity.data.repositories.characters

import androidx.core.net.toUri
import com.tusxdie.starwarsuniversity.data.database.characters.StarWarsCharacterEntity
import com.tusxdie.starwarsuniversity.data.network.models.CharacterResponse
import com.tusxdie.starwarsuniversity.domain.characters.models.StarWarsCharacter

fun CharacterResponse.toDomain() = StarWarsCharacter(
    id = url.toUri().lastPathSegment?.toInt() ?: throw Exception("Invalid character id"),
    name = name,
    birthYear = birthYear,
    gender = when (gender) {
        "male" -> StarWarsCharacter.Gender.MALE
        "female" -> StarWarsCharacter.Gender.FEMALE
        else -> StarWarsCharacter.Gender.MALE
    }
)

fun StarWarsCharacter.toEntity() = StarWarsCharacterEntity(
    id = id,
    name = name,
    birthYear = birthYear,
    gender = when (gender) {
        StarWarsCharacter.Gender.MALE -> StarWarsCharacterEntity.Gender.MALE
        StarWarsCharacter.Gender.FEMALE -> StarWarsCharacterEntity.Gender.FEMALE
    }
)

fun StarWarsCharacterEntity.toDomain() = StarWarsCharacter(
    id = id,
    name = name,
    birthYear = birthYear,
    gender = when (gender) {
        StarWarsCharacterEntity.Gender.MALE -> StarWarsCharacter.Gender.MALE
        StarWarsCharacterEntity.Gender.FEMALE -> StarWarsCharacter.Gender.FEMALE
    }
)