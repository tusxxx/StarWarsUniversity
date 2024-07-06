package com.tusxdie.starwarsuniversity.data.database.films

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDate

@Entity(tableName = "films")
data class FilmEntity(
    @PrimaryKey val urlId: Int,
    val title: String,
    val director: String,
    val producer: String,
    val releaseDate: LocalDate,
    val charactersIds: List<Int>
)