package com.example.notas.ui.theme.main

sealed class MainDestinations(val route: String){
    object HomeScreen: MainDestinations(route = "home")
    object AddScreen: MainDestinations(route = "add")
}
