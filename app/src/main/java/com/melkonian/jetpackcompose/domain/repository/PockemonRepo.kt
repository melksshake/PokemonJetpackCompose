package com.melkonian.jetpackcompose.domain.repository

import androidx.paging.PagingData
import com.melkonian.jetpackcompose.domain.entity.ListItemEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

interface PockemonRepo {
    fun getInitialDataList(dataType: String, coroutineScope: CoroutineScope): Flow<PagingData<ListItemEntity>>
}