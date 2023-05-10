package com.example.test.utils

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.test.R
import com.example.utils.BindableAdapter
import org.koin.core.KoinComponent
import java.net.URL

object BindingUtils: KoinComponent {
    @BindingAdapter("loadRvData")
    @JvmStatic
    fun <T> loadRecyclerViewData(recyclerView: RecyclerView, items: List<T>?) {
        items?.let {
            if (recyclerView.adapter is BindableAdapter<*>) {
                (recyclerView.adapter as BindableAdapter<T>).setData(it)
            }
        }
    }

    @BindingAdapter("loadImageUri")
    @JvmStatic
    fun loadImageUri(view: ImageView, imageUri: String) {
        imageUri.let {
            Glide
                .with(view)
                .load(imageUri)
                .transition(DrawableTransitionOptions.withCrossFade())
                .placeholder(R.color.colorPlaceHolder)
                .into(view)
        }
    }
}