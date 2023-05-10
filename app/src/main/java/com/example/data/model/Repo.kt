package com.example.data.model

import java.io.Serializable

data class Repo (
    val id: Long,
    val name: String,
    val fullName: String,
    val description: String?,
    val html_url: String,
    val stargazers_count: Int,
    val forks_count: Int,
    val language: String?,
    val watchers: Int,
    val created_at: String,
    val updated_at: String,
    val owner: Owner,
    val open_issues: Int

    ) : Serializable {
    constructor(): this(
        0,
        "",
        "",
        "",
        "",
        0,
        0,
        "",
        0,
        "",
        "",
        Owner(),
        0
    )
}