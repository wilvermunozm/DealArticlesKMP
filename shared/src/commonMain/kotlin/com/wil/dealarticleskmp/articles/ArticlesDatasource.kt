package com.wil.dealarticleskmp.articles

class ArticlesDatasource(private val database: ArticlesDb) {
    fun getAllArticles(): List<ArticleRaw> =
        database.articlesDbQueries.selectArticles().executeAsList().map {
            ArticleRaw(
                title = it.title,
                description = it.description,
                publishedAt = it.date,
                urlToImage = it.imageUrl,
                content = "",
                url = ""
            )
        }

    fun insertArticle(article: ArticleRaw) {
        database.articlesDbQueries.insertArticle(
            title = article.title,
            description = article.description,
            date = article.publishedAt,
            imageUrl = article.urlToImage,
        )
    }

    fun insertArticles(articles: List<ArticleRaw>) {
        articles.forEach {
            insertArticle(it)
        }
    }

    fun deleteArticles() {
        database.articlesDbQueries.removeAllArticles()
    }
}