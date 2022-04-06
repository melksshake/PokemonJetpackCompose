package com.melkonian.jetpackcompose.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melkonian.jetpackcompose.domain.entity.PokemonEntity
import com.melkonian.jetpackcompose.domain.interactor.PokemonInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailedViewModel @Inject constructor(
    private val interactor: PokemonInteractor
) : ViewModel() {
    val pokemonDetailed: MutableLiveData<PokemonEntity> = MutableLiveData()

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun getPokemonDetail(id: String) = viewModelScope.launch {
        _isLoading.value = true

        pokemonDetailed.value = interactor.getPokemonDetailed(id)

        _isLoading.value = false
    }
}