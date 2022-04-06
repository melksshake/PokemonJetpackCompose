package com.melkonian.jetpackcompose.data.api

import com.melkonian.jetpackcompose.domain.entity.ListItemEntity
import com.melkonian.jetpackcompose.domain.entity.PaginatedWrapper
import com.melkonian.jetpackcompose.domain.entity.PokemonEntity
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface PokemonApi {
    @GET("{data_type}")
    suspend fun getInitialDataList(@Path(value = "data_type") dataType: String): PaginatedWrapper<ListItemEntity>

    @GET
    suspend fun getDataList(@Url url: String): PaginatedWrapper<ListItemEntity>

    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(@Path("id") id: String): PokemonEntity

//    @GET("berry/{id}")
//    suspend fun getBerryDetail(@Path("id") id: String): Berry
}