package com.example.pokemonapp.domain.usecase

import com.example.pokemonapp.domain.common.Resource
import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.domain.repository.PokemonRepository

// Manter o package do seu app
// Fazer os imports

class GetPokemonByNumberUseCase(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(number: Int): Resource<Pokemon> {
        if (number <= 0) {
            return Resource.Error("Informe um número maior que zero.")
        }

        if (number > 1025) {
            return Resource.Error("Informe um número válido até 1025.")
        }

        return repository.getPokemonByNumber(number)
    }
}