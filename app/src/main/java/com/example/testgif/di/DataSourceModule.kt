package com.example.testgif.di

import com.example.testgif.data.datasource.GifRemoteDataSource
import com.example.testgif.data.network.GifApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataSourceModule {

    @Singleton
    @Provides
    fun provideGifRemoteDataSource(gifApi: GifApi) = GifRemoteDataSource(gifApi)
}