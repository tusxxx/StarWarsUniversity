package com.tusxdie.starwarsuniversity.data.repositories.planets

import com.tusxdie.starwarsuniversity.data.database.planets.PlanetDao
import com.tusxdie.starwarsuniversity.data.network.StarWarsAPI
import com.tusxdie.starwarsuniversity.domain.planets.PlanetsRepository
import com.tusxdie.starwarsuniversity.domain.planets.models.Planet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

class PlanetsRepositoryImpl(
    private val api: StarWarsAPI,
    private val planetsDao: PlanetDao,
    private val coroutineContext: CoroutineContext = Dispatchers.IO
) : PlanetsRepository {
    override fun getPlanet(id: Int): Flow<Planet> = flow {
         planetsDao.getPlanet(id).firstOrNull()?.let {
             emit(it.toDomain())
             return@flow
         }
         val planet = api.getPlanet(id)
             .toDomain()
             .also { planetsDao.insertPlanet(it.toEntity()) }
         emit(planet)
    }.flowOn(coroutineContext)
}