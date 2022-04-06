package com.melkonian.jetpackcompose.data.di

import com.melkonian.jetpackcompose.BuildConfig
import com.melkonian.jetpackcompose.data.api.PokemonApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    companion object {
        private const val CONNECTION_TIMEOUT: Long = 30
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return logging
    }

    @Provides
    fun provideHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .build()

    @Provides
    fun provideConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun providePokemonApi(
        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): PokemonApi = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(converterFactory)
        .client(okHttpClient)
        .build()
        .create(PokemonApi::class.java)
}