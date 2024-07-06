package com.tusxdie.starwarsuniversity.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tusxdie.starwarsuniversity.ui.film.FilmScreen
import com.tusxdie.starwarsuniversity.ui.films.FilmsScreen
import com.tusxdie.starwarsuniversity.ui.planet.PlanetScreen
import com.tusxdie.starwarsuniversity.ui.utils.navigateSafely

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.FilmsScreenRoute.route) {
        composable(route = Screens.FilmsScreenRoute.route) {
            FilmsScreen(
                onNavigateToFilmScreen = {
                    navController.navigateSafely {
                        navigate(Screens.FilmScreenRoute.createRoute(it))
                    }
                }
            )
        }

        composable(
            route = Screens.FilmScreenRoute.route,
            arguments = listOf(navArgument("filmId") { type = NavType.IntType })
        ) { backStackEntry ->
            val filmId = backStackEntry.arguments?.getInt("filmId")
            if (filmId != null) {
                FilmScreen(
                    filmId = filmId,
                    onNavigateToWorldScreen = {
                        navController.navigateSafely {
                            navigate(Screens.PlanetScreenRoute.createRoute(it))
                        }
                    }
                )
            }
        }

        composable(
            route = Screens.PlanetScreenRoute.route,
            arguments = listOf(navArgument("planetId") { type = NavType.IntType })
        ) { backStackEntry ->
            val planetId = backStackEntry.arguments?.getInt("planetId")
            if (planetId != null) {
                PlanetScreen(planetId, onBackClick = { navController.popBackStack() })
            }
        }
    }
}