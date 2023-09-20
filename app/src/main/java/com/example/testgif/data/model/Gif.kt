package com.example.testgif.data.model

import com.google.gson.annotations.SerializedName

data class Gifs(
    @SerializedName("data")
    val data: List<Gif>
)

data class Gif(
    @SerializedName("images")
    val images: Images
)

data class Images(
    @SerializedName("downsized")
    val downsized: Downsized
)

data class Downsized(
    @SerializedName("url")
    val url: String
)
