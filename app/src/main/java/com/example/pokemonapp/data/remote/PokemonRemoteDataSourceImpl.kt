package com.example.pokemonapp.data.remote

import com.example.pokemonapp.data.model.PokemonResponse

// Manter o package

class PokemonRemoteDataSourceImpl(
    private val api: PokemonApi
) : PokemonRemoteDataSource {

    override suspend fun getPokemonByNumber(number: Int): PokemonResponse {
        return api.getPokemonByNumber(number)
    }
}
