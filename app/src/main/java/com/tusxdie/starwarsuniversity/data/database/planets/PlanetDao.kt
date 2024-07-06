package com.tusxdie.starwarsuniversity.data.database.planets

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PlanetDao {
    @Query("SELECT * FROM planets WHERE id = :id")
    fun getPlanet(id: Int): Flow<PlanetEntity?>

    @Insert
    suspend fun insertPlanet(planet: PlanetEntity)
}