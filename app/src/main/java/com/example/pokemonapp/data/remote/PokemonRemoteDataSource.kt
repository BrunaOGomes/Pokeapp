package com.example.pokemonapp.data.remote

import com.example.pokemonapp.data.model.PokemonResponse

// Manter o package

interface PokemonRemoteDataSource {
    suspend fun getPokemonByNumber(number: Int): PokemonResponse
}