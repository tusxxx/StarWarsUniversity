package com.tusxdie.starwarsuniversity.ui.utils

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController

// Prevent from double navigating on double click
fun NavController.navigateSafely(safely: Boolean = true, navigate: NavController.() -> Unit) {
    val state = currentBackStackEntry?.lifecycle?.currentState ?: Lifecycle.State.RESUMED
    if (!safely || state == Lifecycle.State.RESUMED) {
        navigate()
    }
}