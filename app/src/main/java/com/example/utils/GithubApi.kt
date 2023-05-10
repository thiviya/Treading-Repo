package com.example.utils

import com.example.data.model.RepoSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    @GET("search/repositories?q=android&sort=stars&order=desc")
    suspend fun searchRepositories(
        @Query("q") query: String,
        @Query("sort") sort: String,
        @Query("order") order: String
    ): Response<RepoSearchResponse>
}
