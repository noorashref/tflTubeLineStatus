package com.example.tfl.presentation.routing

import java.util.Objects

sealed class Screen(val route: String){
    object TubeListingScreen : Screen("home")
}

