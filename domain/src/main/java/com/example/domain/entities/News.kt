package com.example.domain.entities

data class News(
    val title: String,
    val details: String,
    val guid: String,
    val imageUrl: String,
    val pubDate: String,
    val creator: String,
    val categories: List<String>
)
