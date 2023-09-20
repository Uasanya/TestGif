package com.example.testgif.di

import com.example.testgif.data.datasource.GifRemoteDataSource
import com.example.testgif.data.repository.GifRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module(includes = [NetworkModule::class, DataSourceModule::class])
class RepositoryModule {
    @Singleton
    @Provides
    fun provideGifRepository(gifRemoteDataSource: GifRemoteDataSource) = GifRepository(gifRemoteDataSource)
}