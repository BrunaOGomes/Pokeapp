package com.example.pokemonapp.data.remote

// Manter o package do seu app

import com.example.pokemonapp.data.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon/{number}")
    suspend fun getPokemonByNumber(
        @Path("number") number: Int
    ): PokemonResponse

}