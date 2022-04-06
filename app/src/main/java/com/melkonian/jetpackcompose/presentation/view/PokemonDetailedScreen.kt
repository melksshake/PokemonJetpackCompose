package com.melkonian.jetpackcompose.presentation.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.melkonian.jetpackcompose.domain.entity.PokemonEntity
import com.melkonian.jetpackcompose.presentation.viewmodel.PokemonDetailedViewModel

@Composable
fun PokemonDetailedScreen(
    viewModel: PokemonDetailedViewModel,
    navController: NavController,
    url: String
) {
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = true)
    val pokemon: PokemonEntity? by viewModel.pokemonDetailed.observeAsState()

    viewModel.getPokemonDetail(url)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Pokemon") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                }
            )
        },
        content = {
            PokemonDetailView(pokemon = pokemon)
            Box(
                contentAlignment = Alignment.TopCenter,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 24.dp)
            ) {
                if (isLoading) {
                    CircularProgressIndicator()
                }

            }
        }
    )
}

@Composable
fun PokemonDetailView(pokemon: PokemonEntity?) {
    pokemon?.let {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = 4.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                Text(text = pokemon.name, style = MaterialTheme.typography.h3)
                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Height: ${pokemon.heightInMetre} Metre")
                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Weight: ${pokemon.weightInKilogram} Kg")
                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Base Exp: ${pokemon.baseExperience}")
            }
        }
    }
}