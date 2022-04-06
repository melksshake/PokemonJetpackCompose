package com.melkonian.jetpackcompose.data.di

import com.melkonian.jetpackcompose.data.api.PokemonApi
import com.melkonian.jetpackcompose.data.repository.PokemonRepoImpl
import com.melkonian.jetpackcompose.domain.interactor.PokemonInteractor
import com.melkonian.jetpackcompose.domain.interactor.PokemonInteractorImpl
import com.melkonian.jetpackcompose.domain.repository.PockemonRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class PokemonModule {
    @Binds
    @ApiService
    @ExperimentalCoroutinesApi
    abstract fun bindPokemonApi(impl: PokemonApi): PokemonApi

    @Binds
    abstract fun bindPokemonRepo(impl: PokemonRepoImpl): PockemonRepo

    @Binds
    abstract fun bindPokemonInteractor(impl: PokemonInteractorImpl): PokemonInteractor
}