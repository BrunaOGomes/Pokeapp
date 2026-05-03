package com.example.pokemonapp.domain.repository

import com.example.pokemonapp.domain.common.Resource
import com.example.pokemonapp.domain.model.Pokemon

// Manter o package do seu app
// Fazer os imports


interface PokemonRepository {
    suspend fun getPokemonByNumber(number: Int): Resource<Pokemon>
}