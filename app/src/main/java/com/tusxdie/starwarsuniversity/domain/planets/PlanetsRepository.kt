package com.tusxdie.starwarsuniversity.domain.planets

import com.tusxdie.starwarsuniversity.domain.planets.models.Planet
import kotlinx.coroutines.flow.Flow

interface PlanetsRepository {
    fun getPlanet(id: Int): Flow<Planet>
}