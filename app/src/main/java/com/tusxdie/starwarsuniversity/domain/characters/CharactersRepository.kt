package com.tusxdie.starwarsuniversity.domain.characters

import com.tusxdie.starwarsuniversity.domain.characters.models.StarWarsCharacter
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    fun getCharacter(id: Int): Flow<StarWarsCharacter>
}