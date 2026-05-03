package com.example.pokemonapp.presentation.pokemon.detail

// Manter o package

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.domain.common.Resource
import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.domain.usecase.GetPokemonByNumberUseCase
import com.example.pokemonapp.presentation.commin.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonDetailViewModel(
    private val getPokemonByNumberUseCase: GetPokemonByNumberUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<Pokemon>>(
        UiState.Initial
    )
    val uiState: StateFlow<UiState<Pokemon>> = _uiState

    fun getPokemonByNumber(number: Int) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading

            when (val result = getPokemonByNumberUseCase(number)) {
                is Resource.Success -> {
                    _uiState.value = UiState.Success(result.data)
                }

                is Resource.Error -> {
                    _uiState.value = UiState.Error(result.message)
                }

                Resource.Loading -> {
                    _uiState.value = UiState.Loading
                }
            }
        }
    }
}