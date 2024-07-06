package com.tusxdie.starwarsuniversity.data.network

import com.tusxdie.starwarsuniversity.data.network.models.CharacterResponse
import com.tusxdie.starwarsuniversity.data.network.models.FilmResponse
import com.tusxdie.starwarsuniversity.data.network.models.FilmsResponse
import com.tusxdie.starwarsuniversity.data.network.models.PlanetResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface StarWarsAPI {
    @GET("films/")
    suspend fun getFilms(): FilmsResponse

    @GET("films/{id}/")
    suspend fun getFilm(@Path("id") id: Int): FilmResponse

    @GET("people/{id}/")
    suspend fun getCharacter(@Path("id") id: Int): CharacterResponse

    @GET("planets/{id}/")
    suspend fun getPlanet(@Path("id") id: Int): PlanetResponse
}