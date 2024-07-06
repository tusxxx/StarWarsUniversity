package com.tusxdie.starwarsuniversity.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.tusxdie.starwarsuniversity.data.network.StarWarsAPI
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit

private val json = Json {
    ignoreUnknownKeys = true
}

val networkModule = module {
    single<StarWarsAPI> {
        get<Retrofit>().create(StarWarsAPI::class.java)
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(get<Converter.Factory>())
            .client(get<OkHttpClient>())
            .build()
    }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()
    }

    single<Converter.Factory> {
        json.asConverterFactory("application/json".toMediaType())
    }
}