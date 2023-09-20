package com.example.testgif.data.datasource

import com.example.testgif.data.model.Gifs
import com.example.testgif.data.network.GifApi
import javax.inject.Inject

class GifRemoteDataSource @Inject constructor(private val gifApi: GifApi) {

    suspend fun getGifs(): Gifs = gifApi.getGifs()
}