package com.wil.dealarticleskmp.articles.domain

data class Article(
    val id: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String,
)