package com.tusxdie.starwarsuniversity.data.database.characters

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface StarWarsCharacterDao {
    @Query("SELECT * FROM star_wars_characters WHERE id = :id")
    fun getCharacter(id: Int): Flow<StarWarsCharacterEntity?>

    @Insert
    suspend fun insertCharacter(character: StarWarsCharacterEntity)
}
