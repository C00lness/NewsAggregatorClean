package com.example.data.api

import com.example.data.entities.RssDto
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("/{query}/rss")
    suspend fun getRss(
        @Path("query") query: String = "international"
    ): RssDto
}