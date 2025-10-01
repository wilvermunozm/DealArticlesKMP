package com.wil.dealarticleskmp.articles.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(
    private val client: HttpClient
) {
    private val countryCode = "us"
    private val category = "business"
    private val apiKey = "4e106ac12c7941f78864dc0768d47b44"

    suspend fun fetchArticles(): List<ArticleRaw> {
        val response: ArticlesResponse = client.get(
            "https://newsapi.org/v2/top-headlines?country=$countryCode&category=$category&apiKey=$apiKey"
        ).body()

        return response.articles
    }
}