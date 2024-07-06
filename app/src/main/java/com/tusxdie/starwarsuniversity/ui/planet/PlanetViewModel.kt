package com.tusxdie.starwarsuniversity.ui.planet

import androidx.lifecycle.viewModelScope
import com.tusxdie.starwarsuniversity.domain.planets.PlanetsRepository
import com.tusxdie.starwarsuniversity.ui.utils.LCE
import com.tusxdie.starwarsuniversity.ui.utils.StateViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PlanetViewModel(
    private val planetRepository: PlanetsRepository
) : StateViewModel<PlanetScreenState>(PlanetScreenState()) {

    fun fetchPlanet(planetId: Int) {
        viewModelScope.launch {
            planetRepository.getPlanet(planetId).collectLatest { planet ->
                _state.update {
                    it.copy(planetUI = planet.toPlanetUI(), lce = LCE.Dormant)
                }
            }
        }
    }
}

data class PlanetScreenState(
    val planetUI: PlanetUI = PlanetUI(),
    val lce: LCE = LCE.Loading
) {
    data class PlanetUI(
        val name: String = "",
        val diameter: String = "",
        val climate: String = "",
        val gravity: String = "",
        val terrain: String = "",
        val population: String = "",
    )
}