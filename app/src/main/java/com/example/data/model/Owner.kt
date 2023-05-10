package com.example.data.model

import java.io.Serializable

data class Owner(
    val id: Int,
    val login: String,
    val avatar_url: String
) : Serializable {
    constructor() : this(
        0,
        "",
        ""
    )
}