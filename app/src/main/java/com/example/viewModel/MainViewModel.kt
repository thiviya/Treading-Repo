package com.example.viewModel

import android.content.Context
import android.content.Intent
import androidx.lifecycle.*
import com.example.data.GithubRepository
import com.example.data.model.Repo
import com.example.ui.DetailsActivity
import kotlinx.coroutines.launch
import org.json.JSONException
import org.koin.core.KoinComponent

class MainViewModel() : ViewModel(), KoinComponent {

    private val repository = GithubRepository()
    private var repoList = listOf<Repo>()

    val isLoading: LiveData<Boolean>
        get() = _isLoading
    private val _isLoading = MutableLiveData<Boolean>()

    val isError: LiveData<Boolean>
        get() = _isError
    private val _isError = MutableLiveData<Boolean>()

    private val _queryList = MutableLiveData<List<Repo>>()
    val queryList: LiveData<List<Repo>> = _queryList

    fun loadTrendingRepositories() {
        _isLoading.value = true
        _isError.value = false
        viewModelScope.launch {
            try {
                repoList = repository.getTrendingRepositories()
                _queryList.value = repoList
                _isLoading.value = false
            } catch (e: JSONException) {
                e.printStackTrace()
                _isError.value = true
            }

        }
    }

    fun onRetryClick(context: Context) {
        loadTrendingRepositories()
    }

    fun onRepoClick(repo: Repo, context: Context) {
        context.startActivity(Intent(context, DetailsActivity::class.java).putExtra("repo", repo))
    }

    fun searchRepos(query: String) {
        _queryList.value =
            repoList.filter { repo ->
                repo.name.toLowerCase().contains(query.toLowerCase()) || repo.language?.toLowerCase()?.contains(query.toLowerCase()) == true
            }
    }
}