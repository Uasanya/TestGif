package com.example.testgif.data.repository

import com.example.testgif.data.datasource.GifRemoteDataSource
import com.example.testgif.data.model.Gif
import com.example.testgif.data.model.Gifs
import javax.inject.Inject

class GifRepository @Inject constructor(private val gifRemoteDataSource: GifRemoteDataSource) {

    suspend fun loadGifs(): Gifs = gifRemoteDataSource.getGifs()
}