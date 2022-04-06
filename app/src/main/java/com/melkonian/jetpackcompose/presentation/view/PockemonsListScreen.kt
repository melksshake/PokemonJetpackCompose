package com.melkonian.jetpackcompose.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.melkonian.jetpackcompose.domain.entity.InitialListDataType
import com.melkonian.jetpackcompose.presentation.route.getPokemonDetailRoute
import com.melkonian.jetpackcompose.presentation.viewmodel.PokemonsListViewModel

@Composable
fun PokemonListScreen(
    viewModel: PokemonsListViewModel,
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBarView(
            title = InitialListDataType.POKEMON.name,
            buttonIcon = Icons.Filled.ArrowBack,
            onButtonClicked = null
        )

        PaginatedList(viewModel.pokemonsList) {
            navController.navigate(getPokemonDetailRoute(it))
        }
    }
}