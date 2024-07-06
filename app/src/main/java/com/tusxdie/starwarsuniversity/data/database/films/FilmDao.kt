package com.tusxdie.starwarsuniversity.data.database.films

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmDao {
    @Query("SELECT * FROM films WHERE urlId = :urlId")
    fun getFilm(urlId: Int): Flow<FilmEntity?>

    @Query("SELECT * FROM films")
    fun getFilms(): Flow<List<FilmEntity>>

    @Insert
    suspend fun insertFilm(film: FilmEntity)
}
