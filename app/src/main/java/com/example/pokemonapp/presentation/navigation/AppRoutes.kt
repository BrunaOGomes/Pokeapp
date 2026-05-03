package com.example.pokemonapp.presentation.navigation

// MANTER SEU PACKAGE

object AppRoutes {
    const val POKEMON_LIST = "pokemon_list"
    const val POKEMON_SEARCH = "pokemon_search"
    const val POKEMON_DETAIL = "pokemon_detail/{pokemonNumber}"

    fun pokemonDetail(pokemonNumber: Int): String {
        return "pokemon_detail/$pokemonNumber"
    }
}