package com.melkonian.jetpackcompose.presentation.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.melkonian.jetpackcompose.domain.entity.ListItemEntity
import kotlinx.coroutines.flow.Flow

@Composable
fun PaginatedList(
    items: Flow<PagingData<ListItemEntity>>,
    onItemClicked: (String) -> Unit,
) {
    val lazyPokemonsItem = items.collectAsLazyPagingItems()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
    ) {
        items(lazyPokemonsItem) { item ->
            item?.let { PagedItemView(item = item, onItemClicked) }
        }
    }
}

@Composable
fun PagedItemView(
    item: ListItemEntity,
    onItemClicked: (String) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable {
                onItemClicked(item.url.toUri().lastPathSegment ?: "0")
            },
        elevation = 4.dp
    ) {
        Text(
            text = item.name,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(16.dp)
        )
    }
}