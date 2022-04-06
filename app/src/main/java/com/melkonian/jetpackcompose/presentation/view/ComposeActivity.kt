package com.melkonian.jetpackcompose.presentation.view

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.melkonian.jetpackcompose.domain.entity.InitialListDataType
import com.melkonian.jetpackcompose.presentation.route.POKEMON_DETAIL
import com.melkonian.jetpackcompose.presentation.viewmodel.PokemonDetailedViewModel
import com.melkonian.jetpackcompose.presentation.viewmodel.PokemonsListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun MainScreen() {
        //val isLocalInspectionMode = LocalInspectionMode.current

        Scaffold {
            val navController = rememberNavController()
            NavigationComponent(navController)
        }
    }

    @Composable
    fun NavigationComponent(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = InitialListDataType.POKEMON.value
        ) {
            composable(InitialListDataType.POKEMON.value) {
                val viewModel = hiltViewModel<PokemonsListViewModel>()
                PokemonListScreen(viewModel, navController)
            }
            composable(POKEMON_DETAIL) { backStackEntry ->
                backStackEntry.arguments?.getString("url")?.let {
                    val viewModel = hiltViewModel<PokemonDetailedViewModel>()
                    PokemonDetailedScreen(
                        viewModel = viewModel,
                        navController = navController,
                        url = it,
                    )
                }
            }
        }
    }
}