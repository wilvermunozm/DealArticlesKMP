package com.wil.dealarticleskmp.articles

class ArticlesUseCase(private val articlesService: ArticlesService) {
    suspend fun fetchArticles(): List<Article> {
        return articlesService.fetchArticles().map {
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