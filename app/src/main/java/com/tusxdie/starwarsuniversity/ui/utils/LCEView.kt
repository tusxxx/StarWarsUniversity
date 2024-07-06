package com.tusxdie.starwarsuniversity.ui.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LCEView(
    lce: LCE,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    when (lce) {
        LCE.Loading -> LoadingView(modifier)
        LCE.Error -> ErrorView(modifier)
        LCE.Dormant -> content()
    }
}

@Composable
private fun ErrorView(modifier: Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()) {
        Text(text = "Something go wrong")
    }
}

@Composable
fun LoadingView(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}
