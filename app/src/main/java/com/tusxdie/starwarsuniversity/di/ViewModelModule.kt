package com.tusxdie.starwarsuniversity.di

import com.tusxdie.starwarsuniversity.ui.film.FilmViewModel
import com.tusxdie.starwarsuniversity.ui.films.FilmsViewModel
import com.tusxdie.starwarsuniversity.ui.planet.PlanetViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { FilmsViewModel(get()) }
    factory { FilmViewModel(get(), get()) }
    factory { PlanetViewModel(get()) }
}