package com.wil.dealarticleskmp.articles

import com.wil.dealarticleskmp.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> =
        MutableStateFlow(ArticlesState(isLoading = true))

    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        loadArticles()
    }

    fun loadArticles() {
        scope.launch {
            delay(500)
            val fetchedArticles = fetchArticles()
            _articlesState.emit(
                ArticlesState(
                    articles = fetchedArticles,
                    isLoading = false
                )
            )
        }
    }

    suspend fun fetchArticles(): List<Article> = mockArticles

    private val mockArticles = listOf(
        Article(
            id = "1",
            title = "Article 1",
            description = "Description 1",
            url = "https://example.com",
            urlToImage = "https://example.com",
            publishedAt = "2022-01-01",
            content = "Content 1"
        ),
        Article(
            id = "2",
            title = "Article 2",
            description = "Description 2",
            url = "https://example.com",
            urlToImage = "https://example.com",
            publishedAt = "2022-01-02",
            content = "Content 2"
        ),
        Article(
            id = "3",
            title = "Article 3",
            description = "Description 3",
            url = "https://example.com",
            urlToImage = "https://example.com",
            publishedAt = "2022-01-03",
            content = "Content 3"
        )
    )

}