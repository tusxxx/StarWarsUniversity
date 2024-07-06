package com.tusxdie.starwarsuniversity.data.repositories.planets

import androidx.core.net.toUri
import com.tusxdie.starwarsuniversity.data.database.planets.PlanetEntity
import com.tusxdie.starwarsuniversity.data.network.models.PlanetResponse
import com.tusxdie.starwarsuniversity.domain.planets.models.Planet

fun PlanetResponse.toDomain() = Planet(
    name = name,
    diameter = diameter,
    climate = climate,
    gravity = gravity,
    terrain = terrain,
    population = population,
    id = url.toUri().lastPathSegment?.toInt() ?: throw Exception("Invalid planet id")
)

fun Planet.toEntity() = PlanetEntity(
    name = name,
    diameter = diameter,
    climate = climate,
    gravity = gravity,
    terrain = terrain,
    population = population,
    id = id
)

fun PlanetEntity.toDomain() = Planet(
    name = name,
    diameter = diameter,
    climate = climate,
    gravity = gravity,
    terrain = terrain,
    population = population,
    id = id
)