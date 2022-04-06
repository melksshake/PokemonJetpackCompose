package com.melkonian.jetpackcompose.presentation.route

const val POKEMON_DETAIL = "pokemonDetail/{url}"
const val BERRY_DETAIL = "berryDetail/{url}"

fun getPokemonDetailRoute(url: String) = "pokemonDetail/$url"
fun getBerryDetailRoute(url: String) = "berryDetail/$url"