package com.melkonian.jetpackcompose.data.repository

import androidx.paging.*
import com.melkonian.jetpackcompose.data.api.PokemonApi
import com.melkonian.jetpackcompose.data.datasource.PokemonsListPagingDataSource
import com.melkonian.jetpackcompose.domain.entity.ListItemEntity
import com.melkonian.jetpackcompose.domain.repository.PockemonRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonRepoImpl @Inject constructor(
    private val pokemonApi: PokemonApi
) : PockemonRepo {
    override fun getInitialDataList(
        dataType: String,
        coroutineScope: CoroutineScope
    ): Flow<PagingData<ListItemEntity>> {
        val pagingSource = PokemonsListPagingDataSource(dataType, pokemonApi)

        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { pagingSource }
        ).flow.cachedIn(coroutineScope)
    }
}