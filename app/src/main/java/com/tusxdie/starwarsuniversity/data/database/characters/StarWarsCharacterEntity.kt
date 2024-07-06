package com.tusxdie.starwarsuniversity.data.database.characters

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "star_wars_characters")
data class StarWarsCharacterEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val birthYear: String,
    val gender: Gender
) {
    enum class Gender {
        MALE, FEMALE
    }
}