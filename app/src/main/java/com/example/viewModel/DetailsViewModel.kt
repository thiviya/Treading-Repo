package com.example.viewModel

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.model.Repo
import com.example.utils.DateUtils
import org.koin.core.KoinComponent

class DetailsViewModel (): ViewModel(), KoinComponent {


    val dateUtils : DateUtils
        get() =  DateUtils



    fun onOpenBrowserClick(repo: Repo, context: Context){
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(repo.html_url))
        context.startActivity(browserIntent)
    }
}