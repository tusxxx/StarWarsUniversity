package com.tusxdie.starwarsuniversity.di

import com.tusxdie.starwarsuniversity.data.repositories.planets.PlanetsRepositoryImpl
import com.tusxdie.starwarsuniversity.data.repositories.characters.CharactersRepositoryImpl
import com.tusxdie.starwarsuniversity.data.repositories.films.FilmsRepositoryImpl
import com.tusxdie.starwarsuniversity.domain.characters.CharactersRepository
import com.tusxdie.starwarsuniversity.domain.films.FilmsRepository
import com.tusxdie.starwarsuniversity.domain.planets.PlanetsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<FilmsRepository> { FilmsRepositoryImpl(get(), get()) }
    single<CharactersRepository> { CharactersRepositoryImpl(get(), get()) }
    single<PlanetsRepository> { PlanetsRepositoryImpl(get(), get()) }
}