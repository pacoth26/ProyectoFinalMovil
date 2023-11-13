package com.example.notas.ui.theme.main

import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notas.ui.theme.NotasTheme
import com.example.notas.ui.theme.main.viewmodels.NoteViewModel
import com.example.notas.ui.theme.main.views.AddScreen
import com.example.notas.ui.theme.main.views.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotasTheme {
                val navController = rememberNavController()
                val noteViewModel: NoteViewModel= hiltViewModel()
                NavHost(navController = navController, startDestination =MainDestinations.HomeScreen.route) {
                    composable(MainDestinations.HomeScreen.route) {
                        HomeScreen(onNavigate = { screen ->
                            navigate(navHostController = navController, destination = screen)
                        },
                        noteState = noteViewModel.state.value)
                    }
                    composable(MainDestinations.AddScreen.route) {
                        AddScreen(onEvent = { event ->
                            noteViewModel.onEvent(noteEvent = event)
                        },
                            noteState = noteViewModel.state.value,
                            onNavigate = { screen ->
                                navigate(navHostController = navController, destination = screen)
                            }
                            )
                    }

                }
            }
            }
        }
    private fun navigate(navHostController: NavHostController, destination: MainDestinations) {
        navHostController.navigate(destination.route){
            //Guarda el estado de la pantalla
            popUpTo(navHostController.graph.findStartDestination().id){
                saveState = true
            }
            //Una pantalla solo se ejecuta una vez
            //Que una pantalla solo tenga una instancia
            launchSingleTop = true
        }
    }
}

