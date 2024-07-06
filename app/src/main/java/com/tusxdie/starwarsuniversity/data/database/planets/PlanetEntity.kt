package com.tusxdie.starwarsuniversity.data.database.planets

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "planets")
data class PlanetEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val population: String,
    val climate: String,
    val terrain: String,
    val diameter: String,
    val gravity: String
)