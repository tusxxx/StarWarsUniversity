package com.tusxdie.starwarsuniversity.ui.film.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tusxdie.starwarsuniversity.ui.film.FilmScreenState
import com.tusxdie.starwarsuniversity.ui.theme.medium

@Composable
fun CharacterCard(
    modifier: Modifier = Modifier,
    character: FilmScreenState.FilmCharacter,
    onClick: (id: Int) -> Unit
) {
    ElevatedCard(onClick = { onClick(character.id) }, modifier = modifier) {
        Column(Modifier.padding(medium)) {
            Text(text = character.name, style = MaterialTheme.typography.titleLarge)
            Text(text = character.birthYear)
            Text(text = character.gender.name)
        }
    }
}