package com.melkonian.jetpackcompose.domain.entity

data class PaginatedWrapper<T>(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<T>
)