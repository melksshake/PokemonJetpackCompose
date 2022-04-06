package com.melkonian.jetpackcompose.domain.interactor

import androidx.paging.PagingData
import com.melkonian.jetpackcompose.domain.entity.ListItemEntity
import com.melkonian.jetpackcompose.domain.entity.PokemonEntity
import com.melkonian.jetpackcompose.domain.repository.PockemonRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonInteractorImpl @Inject constructor(
    private val repo: PockemonRepo
) : PokemonInteractor {
    override fun getInitialDataList(
        dataType: String,
        coroutineScope: CoroutineScope
    ): Flow<PagingData<ListItemEntity>> {
        return repo.getInitialDataList(dataType, coroutineScope)
    }

    override suspend fun getPokemonDetailed(id: String): PokemonEntity {
        return repo.getPokemonDetailed(id)
    }
}