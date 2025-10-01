package com.wil.dealarticleskmp.articles.domain

import com.wil.dealarticleskmp.articles.data.ArticlesRepository

class ArticlesUseCase(private val articlesRepository: ArticlesRepository) {
    suspend fun fetchArticles(): List<Article> {
        return articlesRepository.getAllArticles().map {
            Article(
                id = "",
                title = it.title,
                description = it.description ?: "",
                publishedAt = it.publishedAt,
                url = it.url,
                urlToImage = it.urlToImage ?: "",
                content = it.content ?: ""
            )
        }
    }
}