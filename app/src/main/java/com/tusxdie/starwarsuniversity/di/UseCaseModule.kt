package com.tusxdie.starwarsuniversity.di

import com.tusxdie.starwarsuniversity.domain.characters.GetCharactersByFilmIdUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetCharactersByFilmIdUseCase(get(), get()) }
}