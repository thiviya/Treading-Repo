package com.example.utils

interface BindableAdapter<T> {
    fun setData(items: List<T>)
    fun refreshData()
}