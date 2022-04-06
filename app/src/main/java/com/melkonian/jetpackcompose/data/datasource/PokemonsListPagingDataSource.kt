package com.melkonian.jetpackcompose.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.melkonian.jetpackcompose.data.api.PokemonApi
import com.melkonian.jetpackcompose.domain.entity.ListItemEntity

class PokemonsListPagingDataSource(
    private val dataType: String,
    private val api: PokemonApi
) : PagingSource<String, ListItemEntity>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, ListItemEntity> {
        return try {
            val response = params.key?.let {
                api.getDataList(it)
            } ?: api.getInitialDataList(dataType)

            LoadResult.Page(
                data = response.results,
                prevKey = response.previous,
                nextKey = response.next
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<String, ListItemEntity>): String? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey ?: anchorPage?.nextKey
        }
    }
}