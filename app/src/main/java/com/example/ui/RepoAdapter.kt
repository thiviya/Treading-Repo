package com.example.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.viewModel.MainViewModel
import com.example.data.model.Repo
import com.example.test.R
import com.example.test.databinding.ItemRepoBinding
import com.example.utils.BindableAdapter
import org.koin.core.KoinComponent

class RepoAdapter (private val mainViewModel: MainViewModel, private val context: Context) :
    RecyclerView.Adapter<RepoAdapter.PastJobViewHolder>(),
    KoinComponent,
    BindableAdapter<Repo> {

    private var repoList: List<Repo> = emptyList()

    override fun setData(items: List<Repo>) {
        repoList = items
        notifyDataSetChanged()
    }

    override fun refreshData() {
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PastJobViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemRepoBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_repo, parent, false)
        binding.viewModel = mainViewModel
        return PastJobViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return repoList.size
    }

    override fun onBindViewHolder(holder: PastJobViewHolder, position: Int) {
        holder.bind(repoList[position])
    }

    inner class PastJobViewHolder(private val binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(repo: Repo) {

            binding.repo = repo
        }
    }

}