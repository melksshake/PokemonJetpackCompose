package com.melkonian.jetpackcompose.domain.interactor

import androidx.paging.PagingData
import com.melkonian.jetpackcompose.domain.entity.ListItemEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

interface PokemonInteractor {
    fun getInitialDataList(dataType: String, coroutineScope: CoroutineScope): Flow<PagingData<ListItemEntity>>
}