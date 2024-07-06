package com.tusxdie.starwarsuniversity.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tusxdie.starwarsuniversity.ui.navigation.AppNavigation
import com.tusxdie.starwarsuniversity.ui.theme.StarWarsUniverisityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StarWarsUniverisityTheme {
                AppNavigation()
            }
        }
    }
}
