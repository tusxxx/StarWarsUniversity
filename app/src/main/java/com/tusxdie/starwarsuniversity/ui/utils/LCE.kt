package com.tusxdie.starwarsuniversity.ui.utils

sealed interface LCE {
    data object Loading : LCE
    data object Dormant : LCE
    data object Error : LCE
}