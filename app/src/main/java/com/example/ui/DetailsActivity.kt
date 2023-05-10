package com.example.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.example.data.model.Repo
import com.example.test.R
import com.example.test.databinding.ActivityDetailsBinding
import com.example.viewModel.DetailsViewModel
import kotlinx.android.synthetic.main.activity_details.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailsActivity : AppCompatActivity() {
    private val detailViewModel by viewModel<DetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityDetailsBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_details
        )

        binding.viewModel = detailViewModel
        binding.lifecycleOwner = this

        setSupportActionBar(toolbar as Toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true);
            it.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24)
            it.title = getString(R.string.repo_details)
        }

        binding.repo = intent.extras?.get("repo") as Repo
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}