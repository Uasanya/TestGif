package com.example.testgif.data.network

import com.example.testgif.data.model.Gifs
import retrofit2.http.GET
import retrofit2.http.Query

interface GifApi {

    @GET("v1/gifs/search")
    suspend fun getGifs(
        @Query("api_key") apiKey: String = "GQ8bnIIZoawoRCXzwJxGq5d4jwy8KMTN",
        @Query("q") q: String = "cheeseburgers",
        @Query("limit") count: Int = 25,
        @Query("offset") offset: Int = 0,
        @Query("rating") rating: String = "g",
        @Query("lang") lang: String = "en"
    ): Gifs
}