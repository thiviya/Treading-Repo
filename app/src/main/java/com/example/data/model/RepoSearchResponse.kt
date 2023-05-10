package com.example.data.model

import java.io.Serializable

data class RepoSearchResponse(
    val items: List<Repo>
) : Serializable {
    constructor() : this(
        mutableListOf()
    )
}