package com.tusxdie.starwarsuniversity.data.repositories.characters

import com.tusxdie.starwarsuniversity.data.database.characters.StarWarsCharacterDao
import com.tusxdie.starwarsuniversity.data.network.StarWarsAPI
import com.tusxdie.starwarsuniversity.domain.characters.CharactersRepository
import com.tusxdie.starwarsuniversity.domain.characters.models.StarWarsCharacter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

class CharactersRepositoryImpl(
    private val api: StarWarsAPI,
    private val charactersDao: StarWarsCharacterDao,
    private val coroutineContext: CoroutineContext = Dispatchers.IO
) : CharactersRepository {
    override fun getCharacter(id: Int): Flow<StarWarsCharacter> = flow {
        charactersDao.getCharacter(id).firstOrNull()?.let {
            emit(it.toDomain())
            return@flow
        }
        val character = api.getCharacter(id)
            .toDomain()
            .also {
                charactersDao.insertCharacter(it.toEntity())
            }
        emit(character)
    }.flowOn(coroutineContext)
}