package com.melkonian.jetpackcompose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.melkonian.jetpackcompose.domain.entity.InitialListDataType
import com.melkonian.jetpackcompose.domain.entity.ListItemEntity
import com.melkonian.jetpackcompose.domain.interactor.PokemonInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PokemonsListViewModel @Inject constructor(
    private val interactor: PokemonInteractor
) : ViewModel() {
    val pokemonsList: Flow<PagingData<ListItemEntity>> by lazy { loadData() }

    private fun loadData(): Flow<PagingData<ListItemEntity>> {
        return interactor.getInitialDataList(InitialListDataType.POKEMON.value, viewModelScope)
    }
}