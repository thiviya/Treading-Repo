package com.example.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.data.model.Repo
import com.example.utils.GithubApi
import com.example.utils.GithubApi.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubRepository  {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(GithubApi::class.java)
    suspend fun getTrendingRepositories(): List<Repo> {
        val response = api.searchRepositories(
            "stars:>1", "stars", "desc"
        )
        return if (response.isSuccessful) {
            response.body()?.items ?: emptyList()
        } else {
            emptyList()
        }
    }
}