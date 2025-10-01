package com.wil.dealarticleskmp.articles.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleRaw(
    @SerialName("title")
    val title: String,

    @SerialName("description")
    val description: String?,

    @SerialName("publishedAt")
    val publishedAt: String,

    @SerialName("url")
    val url: String,

    @SerialName("urlToImage")
    val urlToImage: String?,

    @SerialName("content")
    val content: String?
)