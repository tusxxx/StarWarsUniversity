package com.tusxdie.starwarsuniversity.ui.planet

import com.tusxdie.starwarsuniversity.domain.planets.models.Planet

fun Planet.toPlanetUI() = PlanetScreenState.PlanetUI(
    name = name,
    diameter = diameter,
    climate = climate,
    gravity = gravity,
    terrain = terrain,
    population = population
)