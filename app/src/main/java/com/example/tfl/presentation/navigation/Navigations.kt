package com.example.tfl.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tfl.presentation.routing.Screen
import com.example.tfl.presentation.screens.TubeLineStatusScreen
import com.example.tfl.presentation.viewModel.TubeLineStatusViewModel


@Composable
fun Navigation(){
    val navHostController = rememberNavController()

    val viewModel : TubeLineStatusViewModel = hiltViewModel()

    NavHost(navController = navHostController,
        startDestination = Screen.TubeListingScreen.route ){
        composable(route = Screen.TubeListingScreen.route){
            TubeLineStatusScreen(navHostController,viewModel= viewModel)
        }
    }
}