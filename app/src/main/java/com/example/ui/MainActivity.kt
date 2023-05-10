package com.example.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.R
import com.example.test.databinding.ActivityMainBinding
import com.example.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModel<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = RepoAdapter(mainViewModel, this)
        recycler.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        mainViewModel.loadTrendingRepositories()

        swipeRefreshLayout.setOnRefreshListener {
            mainViewModel.onRetryClick(this)
        }

        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    mainViewModel.searchRepos(newText)
                }
                return false
            }
        })

    }
}