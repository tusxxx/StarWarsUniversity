package com.tusxdie.starwarsuniversity.ui.navigation


sealed class Screens(val route: String) {
    data object FilmsScreenRoute : Screens("films")
    data object FilmScreenRoute : Screens("film/{filmId}") {
        fun createRoute(filmId: Int) = "film/$filmId"
    }
    data object PlanetScreenRoute : Screens("planet/{planetId}") {
        fun createRoute(planetId: Int) = "planet/$planetId"
    }
}