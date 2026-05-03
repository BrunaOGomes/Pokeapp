package com.example.pokemonapp.data.repository

import com.example.pokemonapp.data.model.toDomain
import com.example.pokemonapp.data.remote.PokemonRemoteDataSource
import com.example.pokemonapp.domain.common.Resource
import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.domain.repository.PokemonRepository

// Manter o package
// Fazer os imports

class PokemonRepositoryImpl(
    private val remoteDataSource: PokemonRemoteDataSource
) : PokemonRepository {

    override suspend fun getPokemonByNumber(number: Int): Resource<Pokemon> {
        return try {
            val response = remoteDataSource.getPokemonByNumber(number)
            Resource.Success(response.toDomain())
        } catch (exception: Exception) {
            Resource.Error("Não foi possível buscar o Pokémon.")
        }
    }
}