package com.wil.dealarticleskmp.articles.data

class ArticlesRepository(
    private val datasource: ArticlesDatasource,
    private val articlesService: ArticlesService
) {
    suspend fun getAllArticles(): List<ArticleRaw> {
        val localArticles = datasource.getAllArticles()
        if (localArticles.isEmpty()) {
            val articles = articlesService.fetchArticles()
            datasource.insertArticles(articles)
            return articles
        }
        return localArticles
    }
}