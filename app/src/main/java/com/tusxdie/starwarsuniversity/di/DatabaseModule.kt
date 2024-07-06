package com.tusxdie.starwarsuniversity.di

import com.tusxdie.starwarsuniversity.data.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single<AppDatabase> { AppDatabase.getDatabase(androidApplication()) }
    single { get<AppDatabase>().starWarsCharacterDao() }
    single { get<AppDatabase>().filmDao() }
    single { get<AppDatabase>().planetDao() }
}